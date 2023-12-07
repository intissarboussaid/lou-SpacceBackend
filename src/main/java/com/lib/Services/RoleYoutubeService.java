package com.lib.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lib.models.RoleYoutube;
import com.lib.repository.RoleYoutubeRepository;

@Service
public class RoleYoutubeService {
	@Autowired 
	RoleYoutubeRepository roleYoutubeRepository;
	
	
	public RoleYoutube createNewRole(RoleYoutube role ) {
		return roleYoutubeRepository.save(role);
	}
	
	public List<RoleYoutube> GetAllRoles( ) {
		return roleYoutubeRepository.findAll();
	}

}
