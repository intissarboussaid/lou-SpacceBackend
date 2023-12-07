package com.lib.controllers;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
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
import com.lib.payload.request.LoginRequest;
import com.lib.payload.request.SignupRequest;
import com.lib.payload.response.JwtResponse;
import com.lib.payload.response.MessageResponse;
import com.lib.repository.AccountRepository;
import com.lib.repository.AdminRepository;
import com.lib.repository.ClientRepository;
import com.lib.security.services.JwtUtils;
import com.lib.security.services.UserDetailsImpl;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/Admin/")
public class AdminController {
	@Autowired
	AdminRepository adminRepository;
	@Autowired
	AccountRepository accountRepository;
	@Autowired
	PasswordEncoder encoder;
	@Autowired
	ClientRepository clientRepository;
    @Autowired
	 EmailService emailService;
	@Autowired
	AuthenticationManager authenticationManager;
	@Autowired
	JwtUtils jwtUtils;

	
	//update Admin
    @PutMapping("update/{idAdmin}")
    public Admin GereProfil(@PathVariable(value = "idAdmin")long idAdmin, @RequestBody Admin adminDetail) {
    	Admin admin = adminRepository.findById(idAdmin);
    	admin.setAdresseCompagnie(adminDetail.getAdresseCompagnie());
    	admin.setNameCompany(adminDetail.getNameCompany());
    	admin.setTel(adminDetail.getTel());
    	admin.setAdresseInsta(adminDetail.getAdresseInsta());
    	admin.setFirstName(adminDetail.getFirstName());
    	admin.setLastname(adminDetail.getLastname());
    	admin.setCodepostale(adminDetail.getCodepostale());
    	admin.setAdresseFb(adminDetail.getAdresseFb());
    	admin.setAdresseTikTok(adminDetail.getAdresseTikTok());
    	admin.setAdresseEmail(adminDetail.getAdresseEmail());
    	return adminRepository.save(admin);
    	
    }



	@GetMapping("find/{idAdmin}")
	public Admin findAdmin(@PathVariable long idAdmin){
		return adminRepository.findById(idAdmin);
	}
	
	@GetMapping("AllAdmin")
	public List<Admin> FingAllAdmin(){
		return adminRepository.findAll();
	}
	
	@GetMapping("search/{nameCompany}")
	public List<Admin> FindByNameCompany(@PathVariable String nameCompany){
		return adminRepository.findByNameCompany(nameCompany);
	}
	
	
	

}
