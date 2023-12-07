package com.lib.models;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="UserYoutube")
public class UserYoutube {
	@Id
	private String userName;
	private String userFirstName;
	private String userLastName;
	private String userPasswmord;
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name="USER_ROLE_YOUTUBE", joinColumns =  {@JoinColumn(name="USERYOUTUBE_ID")},
			
		                         inverseJoinColumns = { @JoinColumn(name="ROLEYOUTUBE_ID")}
	)
	private Set<RoleYoutube> roleYoutube;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserFirstName() {
		return userFirstName;
	}
	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}
	public String getUserLastName() {
		return userLastName;
	}
	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}
	public String getUserPasswmord() {
		return userPasswmord;
	}
	public void setUserPasswmord(String userPasswmord) {
		this.userPasswmord = userPasswmord;
	}
	
	
	
	public UserYoutube(String userName, String userFirstName, String userLastName, String userPasswmord,
			Set<RoleYoutube> roleYoutube) {
		super();
		this.userName = userName;
		this.userFirstName = userFirstName;
		this.userLastName = userLastName;
		this.userPasswmord = userPasswmord;
		this.roleYoutube = roleYoutube;
	}
	public Set<RoleYoutube> getRole() {
		return roleYoutube;
	}
	public void setRole(Set<RoleYoutube> roleYoutube) {
		this.roleYoutube = roleYoutube;
	}
	public UserYoutube() {
		super();
	}
	
	
	
	

}
