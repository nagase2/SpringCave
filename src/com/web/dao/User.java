package com.web.dao;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

public class User {
	@NotBlank(message="Username cannot be blank")
	@Size(min=3,max=15)
	private String username;
	@NotBlank(message="Password cannot be blank")
	//@Pattern(regexp="^¥¥S+$",message="password is too simple")
	@Size(min=3,max=15)
	private String password;
	@NotBlank(message="Please imput email")
	@Email(message="this is not appear to be a valid email address")
	private String email;
	private boolean enabled = false;
	private String authority;
	
	public User(){
		
	}
	
	public User(String username, String password, boolean enabled,
			String authority) {
		super();
		this.username = username;
		this.password = password;
		this.enabled = enabled;
		this.authority = authority;
	}

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
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public String getAuthority() {
		return authority;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
