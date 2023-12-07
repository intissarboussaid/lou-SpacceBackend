package com.lib.payload.request;


import java.util.Set;

import javax.persistence.Column;

public class SignupRequest {
   // @NotBlank
   // @Size(min = 3, max = 20)
	@Column
    private String username;
 
    /*@NotBlank
    @Size(max = 50)
    @Email*/
	@Column
    private String email;
    
    private Set<String> role;
    
  /*  @NotBlank
    @Size(min = 6, max = 40)*/
    @Column
    private String password;
    @Column(name="enable")
    private boolean enable;
  
    
    public String getUsername() {
        return username;
    }
 
    public void setUsername(String username) {
        this.username = username;
    }
 
    public String getEmail() {
        return email;
    }
 
    public void setEmail(String email) {
        this.email = email;
    }
 
    public String getPassword() {
        return password;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }
    
    public Set<String> getRole() {
      return this.role;
    }
    
    public void setRole(Set<String> role) {
      this.role = role;
    }

	public boolean isEnable() {
		return enable;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}
    
    
}