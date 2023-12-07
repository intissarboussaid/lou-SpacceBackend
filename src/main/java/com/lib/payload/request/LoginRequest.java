package com.lib.payload.request;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
public class LoginRequest {

	@NotBlank
	private String username;

	@NotBlank
	private String password;
	
	@Column(name="enable")
	private boolean enable;
	

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnable() {
		return enable;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}

	
}
