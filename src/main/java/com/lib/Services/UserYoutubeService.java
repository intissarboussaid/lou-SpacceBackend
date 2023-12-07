package com.lib.Services;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lib.models.RoleYoutube;
import com.lib.models.UserYoutube;
import com.lib.repository.RoleYoutubeRepository;
import com.lib.repository.UserYoutubeRepository;

@Service
public class UserYoutubeService {
	@Autowired
	UserYoutubeRepository userYoutubeRepository;
	@Autowired
	RoleYoutubeRepository roleYoutubeRepository;
	
	public UserYoutube createNewUser (UserYoutube userYoutube) {
		return userYoutubeRepository.save(userYoutube);
	}
	
	public RoleYoutube AdminRole() {
		RoleYoutube adminRole = new RoleYoutube();
		adminRole.setRoleName("Admin");
		adminRole.setRoleDescription("Admin Role");
		roleYoutubeRepository.save(adminRole);
		return adminRole;
	}
	
	public RoleYoutube UserRole() {
		
		RoleYoutube userRole = new RoleYoutube();
		userRole.setRoleName("User");
		userRole.setRoleDescription("Default role for newlycreate record");
		roleYoutubeRepository.save(userRole);
		return userRole;
	}
		
	
	public void initRolesAndUser() {
		RoleYoutube adminRole = new RoleYoutube();
		adminRole.setRoleName("Admin");
		adminRole.setRoleDescription("Admin Role");
		roleYoutubeRepository.save(adminRole);
		
		RoleYoutube userRole = new RoleYoutube();
		userRole.setRoleName("User");
		userRole.setRoleDescription("Default role for newlycreate record");
		roleYoutubeRepository.save(userRole);
		
		
		/*UserYoutube adminUser = new UserYoutube();
		adminUser.setUserFirstName("Admin");
		adminUser.setUserLastName("Admin");
		adminUser.setUserName("Admin123");
		adminUser.setUserPasswmord("Admin@pass");
		Set<RoleYoutube> adminRoles =new HashSet<>();
		adminRoles.add(adminRole);
		adminUser.setRole(adminRoles);
		userYoutubeRepository.save(adminUser);
		
		UserYoutube user = new UserYoutube();
		user.setUserFirstName("Intissar");
		user.setUserLastName("BOUSSAID");
		user.setUserName("Intissar123");
		user.setUserPasswmord("Intissar@pass");
		Set<RoleYoutube> userRoles =new HashSet<>();
		userRoles.add(userRole);
		user.setRole(userRoles);
		userYoutubeRepository.save(user);*/
	}

}
