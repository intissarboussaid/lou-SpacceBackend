package com.lib.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lib.Services.RoleYoutubeService;
import com.lib.models.RoleYoutube;

@RestController
@RequestMapping("/RoleYoutube/")
public class RoleYoutubeController {
	
	@Autowired
	private RoleYoutubeService roleYoutubeService;
	
	
	@PostMapping("createNewRole")
	public RoleYoutube createNewRole(@Valid @RequestBody RoleYoutube role) {
		return roleYoutubeService.createNewRole(role);
	}
	

}
