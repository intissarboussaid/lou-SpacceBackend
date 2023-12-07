package com.lib.payload.response;

import java.util.List;

import com.lib.models.Role;

public class JwtResponse {

	private String token;
	private String type = "Bearer";
	private Long id;
	private Long idAdmin;
	private String username;
	private String email;
	private Role roles;
	private boolean enable;

	public JwtResponse(String accessToken, Long id, String username, String email, boolean enable,  Long idAdmin, Role roles) {
		this.token = accessToken;
		this.id = id;
		this.username = username;
		this.email = email;
		this.enable=enable;
		this.idAdmin=idAdmin;
		this.roles = roles;
		
	}



	public String getToken() {
		return token;
	}



	public void setToken(String token) {
		this.token = token;
	}



	public String getType() {
		return type;
	}



	public void setType(String type) {
		this.type = type;
	}



	public Long getIdAdmin() {
		return idAdmin;
	}



	public void setIdAdmin(Long idAdmin) {
		this.idAdmin = idAdmin;
	}



	public void setRoles(Role roles) {
		this.roles = roles;
	}



	public boolean isEnable() {
		return enable;
	}



	public void setEnable(boolean enable) {
		this.enable = enable;
	}



	public String getAccessToken() {
		return token;
	}

	public void setAccessToken(String accessToken) {
		this.token = accessToken;
	}

	public String getTokenType() {
		return type;
	}

	public void setTokenType(String tokenType) {
		this.type = tokenType;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Role getRoles() {
		return roles;
	}
}