package com.lib.controllers;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lib.Services.UserYoutubeService;
import com.lib.models.UserYoutube;
import com.lib.repository.UserYoutubeRepository;

@RestController
@RequestMapping("/UserYoutube/")
public class UserYoutubeController {
	@Autowired
   UserYoutubeService userYoutubeService;
	
	@Autowired
	   UserYoutubeRepository userYoutubeRepository;
	
	@PostConstruct
	public void intiRolesAndUsers() {
		userYoutubeService.initRolesAndUser();
	}
	@PostMapping("RegisterNewUser")
	public UserYoutube RegisterNewUser(@RequestBody UserYoutube userYoutube ) {
		return userYoutubeService.createNewUser(userYoutube);
	}
	
	@GetMapping("GetAllUser")
	public List<UserYoutube> GetAllUser() {
		return userYoutubeRepository.findAll();
	}

	@GetMapping("ForAdmin")
	public String ForAdmin() {
		return "this URL is only accessible to admin";
	}
	@GetMapping({"ForUser"})
	public String ForUser() {
		return "this URL is only accessible to the User";
	}
}
