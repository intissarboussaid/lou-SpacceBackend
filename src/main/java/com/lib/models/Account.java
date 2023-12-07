package com.lib.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(	name = "accounts",uniqueConstraints = { 
		
		@UniqueConstraint(columnNames = "email"),
		@UniqueConstraint(columnNames = "username")  
	})
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	 long idaccount;

	//@NotBlank
	@Size(min=6)
	@Column(name="username")
     String username;


	@Size(max= 50)
	@Email
     String email;


	@Size(min = 6)
	String password;
	@Size(min = 6)
	String confirmationpassword;
	@Column(name="enable")
    boolean enable;
	@ManyToOne
    @JoinColumn(name="role")
    private Role role;
    
	/*@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(	name = "account", 
				joinColumns = @JoinColumn(name = "account_id"), 
				inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles = new HashSet<>();*/

	public long getIdaccount() {
		return idaccount;
	}

	public void setIdaccount(long idaccount) {
		this.idaccount = idaccount;
	}

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

	public boolean isEnable() {
		return enable;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Account(@Size(max = 20) String username, @Size(max = 50) @Email String email,
			@Size(max = 120) String password) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
		
	}

	public Account(@Size(max = 20) String username, @Size(max = 50) @Email String email,
			@Size(max = 120) String password, boolean enable) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
		this.enable = enable;
	}

	public Account() {
		super();
	}

	public String getConfirmationpassword() {
		return confirmationpassword;
	}

	public void setConfirmationpassword(String confirmationpassword) {
		this.confirmationpassword = confirmationpassword;
	}

	public Account(long idaccount, @Size(min = 6) String username, @Size(max = 50) @Email String email,
			@Size(min = 6) String password, @Size(min = 6) String confirmationpassword, boolean enable, Role role) {
		super();
		this.idaccount = idaccount;
		this.username = username;
		this.email = email;
		this.password = password;
		this.confirmationpassword = confirmationpassword;
		this.enable = enable;
		this.role = role;
	}
	

	

}
