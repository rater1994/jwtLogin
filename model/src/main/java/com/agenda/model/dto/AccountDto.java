package com.agenda.model.dto;

import com.agenda.model.entity.Role;

import java.util.Set;

public class AccountDto {

	private Long id;
	private String name;
	private String email;
	private String username;
	private String password;

	private Set <Role> roles;
	private String deleteFlag;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(String deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	public Set <Role> getRoles() {
		return roles;
	}

	public void setRoles(Set <Role> roles) {
		this.roles = roles;
	}
}
