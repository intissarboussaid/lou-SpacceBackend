package com.lib.controllers;



import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.lib.Services.EmailService;
import com.lib.models.Account;
import com.lib.models.Admin;
import com.lib.models.Client;
import com.lib.models.ERole;
import com.lib.models.Product;
import com.lib.models.Role;
import com.lib.payload.request.LoginRequest;
import com.lib.payload.request.SignupRequest;
import com.lib.payload.response.JwtResponse;
import com.lib.payload.response.MessageResponse;
import com.lib.repository.RoleRepository;
import com.lib.security.services.JwtUtils;
import com.lib.security.services.UserDetailsImpl;
import com.lib.repository.AccountRepository;
import com.lib.repository.AdminRepository;
import com.lib.repository.ClientRepository;
import com.lib.repository.ProductRepository;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	AccountRepository accountRepository;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	PasswordEncoder encoder;
	@Autowired
	AdminRepository adminRepository;
	@Autowired
	ClientRepository clientRepository;
	@Autowired
	ProductRepository productRepository;
	@Autowired
	JwtUtils jwtUtils;
	  @Autowired
	 EmailService emailService;

	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword() ));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);
		
		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();		
		/*List<String> roles = userDetails.getAuthorities().stream()
				.map(item -> item.getAuthority())
				.collect(Collectors.toList());*/
		Account user =accountRepository.findBysername(loginRequest.getUsername());
		Admin admin = adminRepository.findByAccount(user);
		System.out.println("user enable : "+user.isEnable());
		Role roleUser = user.getRole();
		
		return ResponseEntity.ok(new JwtResponse(jwt, 
												 userDetails.getId(), 
												 userDetails.getUsername(), 
												 userDetails.getEmail(), 
												 user.isEnable(),
												 admin.getIdAdmin(),
												 roleUser));
	}

	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest, ModelAndView modelAndView) {
		if (accountRepository.existsByUsername(signUpRequest.getUsername())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Username is already taken!"));
		}

		if (accountRepository.existsByEmail(signUpRequest.getEmail())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Email is already in use!"));
		}

		// Create new user's account
		Account user = new Account(signUpRequest.getUsername(), 
							 signUpRequest.getEmail(),
							 encoder.encode(signUpRequest.getPassword()));
		System.out.println("test"+signUpRequest.getUsername());

		/*Set<String> strRoles = signUpRequest.getRole();
		Set<Role> roles = new HashSet<>();

		if (strRoles == null) {
			Role userRole = roleRepository.findByName(ERole.ROLE_USER)
					.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
			roles.add(userRole);
		} else {
			strRoles.forEach(role -> {
				switch (role) {
				case "admin":
					Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(adminRole);

					break;
				case "mod":
					Role modRole = roleRepository.findByName(ERole.ROLE_MODERATOR)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(modRole);

					break;
				default:
					Role userRole = roleRepository.findByName1(ERole.ROLE_USER);
							//n.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(userRole);
				}
			});
		}

		user.setRoles(roles);*/
		user.setEmail(signUpRequest.getEmail());
		user.setEnable(false);
		Account ac =accountRepository.save(user);
		Admin client =new Admin(ac);
		adminRepository.save(client);
	    	System.out.println("test"+signUpRequest.getEmail());
	    	System.out.println("test"+signUpRequest.getPassword());
	    	System.out.println("test enable"+user.isEnable());
	     SimpleMailMessage mailMessage = new SimpleMailMessage();
	     mailMessage.setTo(user.getEmail());
	     mailMessage.setSubject("Active Account!");
	     mailMessage.setFrom("intissarboussaid2@gmail.com");
	     mailMessage.setText("Dear '"+signUpRequest.getUsername()+"'"
	     		+ "We are writing to confirm that your account is currently active and fully functional and Activate your account via the link below. We appreciate your continued use of our services and are here to assist you if you have any questions or concerns.\r\n"
	     		+ "\r\n"
	     		+ "Please keep in mind that your account is subject to our terms and conditions, which can be found on our website. If you have any questions regarding these terms or need assistance with your account, please do not hesitate to contact our support team.\r\n"
	     		+ "\r\n"
	     		+ "Thank you for choosing our services. "
	     		+"Thank you for choosing our services."

	     		+"Best regards,"
	     +"http://localhost:4200/ActiveAccount" );

	     emailService.sendEmail(mailMessage);

	     modelAndView.addObject("email", user.getEmail());

	     modelAndView.setViewName("successfulRegisteration");
		

		return ResponseEntity.ok(user);
	}
	
	//Active Account
	
	@PutMapping("/ActiveAccount/{username}")
	public Account ActiveAccount(@PathVariable(value = "username")String username) {
		Account user = accountRepository.findBysername(username);
		
			user.setEnable(true);
			return accountRepository.save(user);	
	}
	
	//Get Email 
	@GetMapping("/email/{email}")
	public  Account getEmail(@PathVariable("email") String email){
		Account account =accountRepository.findByemail(email); 
		
			 SimpleMailMessage mailMessage = new SimpleMailMessage();
		     mailMessage.setTo(account.getEmail());
		     mailMessage.setSubject("Rest password!");
		     mailMessage.setFrom("intissarboussaid2@gmail.com");
		     mailMessage.setText(
		    		"We received a request to rest your password.,\r\n"
		     		+ "Use the link below to set up a new password for your account.\r\n"
		     		+ "if you did not request to reset your password, ignore this email and the link will expire on this own. "
		     		
		     +"http://localhost:4200/forgotpassword    ");

		     emailService.sendEmail(mailMessage);
		   return account;
		 
	}
	//Forgot Password
	@PutMapping("forgetpassword/{email}")
	public Account ForgetPassword(@PathVariable(value = "email")String email, @Validated @RequestBody Account account) {
		Account user = accountRepository.findByemail(email);
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(account.getPassword());
         String confPass=passwordEncoder.encode(account.getConfirmationpassword());
        user.setPassword(encodedPassword);
		user.setConfirmationpassword(confPass)	;
		
			return accountRepository.save(user);
			   
		
	}
	
	@DeleteMapping("delete/{idAdmin}")
	public String DeleteAccount(@PathVariable(value = "idAdmin")long idAdmin) {
		Admin admin =adminRepository.findById(idAdmin);
		 if (admin==null )
			 return "sorry we don't have user with that identity ";
		Account account=admin.getAccount();
		 if (account==null )
			 return "sorry that user haven't account";
		Account deleteaccount=accountRepository.findById1(account.getIdaccount());
		 if (deleteaccount==null )
			 return "sorry that user haven't account to delete it";
		List<Product> products = productRepository.findByIdAdmin(admin);
		System.out.println("products "+products);
		for(Product product :products ) {
			
			productRepository.delete(product);
			System.out.println("product "+product);	
			 if (products==null )
				 return "sorry that user haven't Product's";
		}
		System.out.println("products "+products);
		adminRepository.delete(admin);
		accountRepository.delete(deleteaccount);
		adminRepository.delete(admin);
		 if (account==null && deleteaccount==null )
				 return "we delete that user";
		 else
			 return "error!";
	}
	
	/*@GetMapping({"forAdmin"})
	@PreAuthorize("hasRole('Admin')")
	public String forAdmin() {
		return "this URL is olny accessible to Admin";  
	}
	
	@GetMapping({"forUser"})
	@PreAuthorize("hasRole('User')")
	public String forUser() {
		return "this URL is olny accessible to User";  
	}*/
	@GetMapping({"GetAllRoles"})
	
	public List<Role> AllROles() {
		return roleRepository.findAll();  
	}
	
	@PostMapping("/signupForAdmin")
	public ResponseEntity<?> registerAdmin(@Valid @RequestBody SignupRequest signUpRequest, ModelAndView modelAndView) {
		if (accountRepository.existsByUsername(signUpRequest.getUsername())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Username is already taken!"));
		}

		if (accountRepository.existsByEmail(signUpRequest.getEmail())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Email is already in use!"));
		}

		// Create new account
		Account user = new Account(signUpRequest.getUsername(), 
							 signUpRequest.getEmail(),
							 encoder.encode(signUpRequest.getPassword()));
		System.out.println("test "+signUpRequest.getUsername());
		Role role = new Role(ERole.ADMIN);
		System.out.println("Role:  "+role);
    	//Role adminRole = roleRepository.findByName1(ERole.ROLE_ADMIN);
		roleRepository.save(role);
    	//role.add(adminRole);
		user.setRole(role);
		user.setEmail(signUpRequest.getEmail());
		user.setEnable(false);
		Account ac =accountRepository.save(user);
		Admin client =new Admin(ac);
		adminRepository.save(client);
	    	System.out.println("test"+signUpRequest.getEmail());
	    	System.out.println("test"+signUpRequest.getPassword());
	    	System.out.println("test enable"+user.isEnable());
	     SimpleMailMessage mailMessage = new SimpleMailMessage();
	     mailMessage.setTo(user.getEmail());
	     mailMessage.setSubject("Active Account!");
	     mailMessage.setFrom("intissarboussaid2@gmail.com");
	     mailMessage.setText("Dear '"+signUpRequest.getUsername()+"'"
	     		+ "We are writing to confirm that your account is currently active and fully functional and Activate your account via the link below. We appreciate your continued use of our services and are here to assist you if you have any questions or concerns.\r\n"
	     		+ "\r\n"
	     		+ "Please keep in mind that your account is subject to our terms and conditions, which can be found on our website. If you have any questions regarding these terms or need assistance with your account, please do not hesitate to contact our support team.\r\n"
	     		+ "\r\n"
	     		+ "Thank you for choosing our services. "
	     		+"Thank you for choosing our services."

	     		+"Best regards,"
	     +"http://localhost:4200/ActiveAccount" );

	     emailService.sendEmail(mailMessage);

	     modelAndView.addObject("email", user.getEmail());

	     modelAndView.setViewName("successfulRegisteration");
		

		return ResponseEntity.ok(user);
	}
	
	@PostMapping("/signupForUser")
	public ResponseEntity<?> SignUpForUser(@Valid @RequestBody SignupRequest signUpRequest, ModelAndView modelAndView) {
		if (accountRepository.existsByUsername(signUpRequest.getUsername())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Username is already taken!"));
		}

		if (accountRepository.existsByEmail(signUpRequest.getEmail())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Email is already in use!"));
		}

		// Create new account
		Account user = new Account(signUpRequest.getUsername(), 
							 signUpRequest.getEmail(),
							 encoder.encode(signUpRequest.getPassword()));
		System.out.println("test "+signUpRequest.getUsername());
		Role role = new Role(ERole.USER);
		System.out.println("Role:  "+role);
    	//Role adminRole = roleRepository.findByName1(ERole.ROLE_ADMIN);
		roleRepository.save(role);
    	//role.add(adminRole);
		user.setRole(role);
		user.setEmail(signUpRequest.getEmail());
		user.setEnable(false);
		Account ac =accountRepository.save(user);
		Admin client =new Admin(ac);
		adminRepository.save(client);
	    	System.out.println("test"+signUpRequest.getEmail());
	    	System.out.println("test"+signUpRequest.getPassword());
	    	System.out.println("test enable"+user.isEnable());
	     SimpleMailMessage mailMessage = new SimpleMailMessage();
	     mailMessage.setTo(user.getEmail());
	     mailMessage.setSubject("Active Account!");
	     mailMessage.setFrom("intissarboussaid2@gmail.com");
	     mailMessage.setText("Dear '"+signUpRequest.getUsername()+"'"
	     		+ "We are writing to confirm that your account is currently active and fully functional and Activate your account via the link below. We appreciate your continued use of our services and are here to assist you if you have any questions or concerns.\r\n"
	     		+ "\r\n"
	     		+ "Please keep in mind that your account is subject to our terms and conditions, which can be found on our website. If you have any questions regarding these terms or need assistance with your account, please do not hesitate to contact our support team.\r\n"
	     		+ "\r\n"
	     		+ "Thank you for choosing our services. "+" "
	     		+"Thank you for choosing our services."

	     		+"Best regards,"
	     +"http://localhost:4200/ActiveAccount" );

	     emailService.sendEmail(mailMessage);

	     modelAndView.addObject("email", user.getEmail());

	     modelAndView.setViewName("successfulRegisteration");
		

		return ResponseEntity.ok(user);
	}
	
	
}