package com.lib.controllers;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lib.models.Role;
import com.lib.models.Account;
import com.lib.repository.RoleRepository;
import com.lib.repository.AccountRepository;



@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class TestController {
	
	@Autowired
	AccountRepository accountRepository;
	@Autowired
	RoleRepository roleRepositor;
	
	@GetMapping("/all")
	public String allAccess() {
		return "Public Content.";
	}
	
	@GetMapping("/user")
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public String userAccess() {
		return "User Content.";
	}

	@GetMapping("/mod")
	@PreAuthorize("hasRole('MODERATOR')")
	public String moderatorAccess() {
		return "Moderator Board.";
	}

	@GetMapping("/admin")
	@PreAuthorize("hasRole('ADMIN')")
	public String adminAccess() {
		return "Admin Board.";
	}
	
	@GetMapping("/getAllUser")
	public List<Account> allUsers() {
		return accountRepository.findAll();
	}
	
	@PostMapping("/createRole")
	public List<Role> allRoles(@Validated @RequestBody Role role) {
		
		roleRepositor.save(role);
		System.out.println("test: "+ role.getName() );
		return roleRepositor.All();
	}
	
	@GetMapping("/getbyIdoptional/{id}")
	public Optional<Account> GetRolByIdOptional(@PathVariable(value = "id")long id) {
		
		/*User user =userRepositor.findById1(id);
		user.setEnable(false);*/
		return accountRepository.findById(id);
	}
	
	@GetMapping("/GetAllRoles")
	public List<Role> GetAllRoles() {
		
		
		return roleRepositor.findAll();
	}
	@GetMapping("/email/{email}")
	public  Account getEmail(@PathVariable("email") String email){
		Account account =accountRepository.findByemail(email); 
		 return account; 
	}
	
	
}