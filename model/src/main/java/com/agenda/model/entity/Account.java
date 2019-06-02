package com.agenda.model.entity;


import com.agenda.model.dto.AccountDto;
import org.hibernate.annotations.NaturalId;
import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;


@Entity
@SQLDelete(sql = "UPDATE users SET delete_flag = 'DELETED' WHERE id = ?", check = ResultCheckStyle.COUNT)
@Where(clause = "delete_flag <> 'DELETED'")
@Table(name = "users")
public class Account {

	@Transient
	Logger log = Logger.getLogger( this.getClass().getName() );

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;

	private String name;

	@Column
	private String username;

	@NaturalId
	@NotBlank
	@Size(max = 50)
	@Email
	private String email;

	@Column(name = "Password")
	private String password;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "user_roles",
			joinColumns = @JoinColumn(name = "user_id"),
			inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set <Role> roles = new HashSet <>();

	@Column(name = "DeleteFlag")
	private String deleteFlag;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List <Contact> contacts;

	public Account(String name, String username, String email, String password, String deleteFlag, List<Contact> contacts) {
		this.name = name;
		this.username = username;
		this.email = email;
		this.password = password;
		this.deleteFlag = deleteFlag;
		this.contacts = contacts;
	}

	public Account() {

	}

	public Long getId() {
		return id;
	}

	public List <Contact> getContacts() {
		return contacts;
	}

	public void setContacts(List <Contact> contacts) {
		this.contacts = contacts;
	}

	public String getUsername() {
		return username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}


	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public AccountDto toAccountDto() {
		AccountDto accountDto = new AccountDto();

		accountDto.setId( this.id );
		accountDto.setName( this.name );
		accountDto.setEmail( this.email );
		accountDto.setUsername( this.username );
		accountDto.setPassword( this.password );
		accountDto.setRoles( this.roles );
		accountDto.setDeleteFlag( this.deleteFlag );

		accountDto.setContactDtos( new ArrayList<>() );
		this.contacts.forEach( contact -> accountDto.getContactDtos().add( contact.toContactDto() ) );

		return accountDto;
	}

	public void updateAccountDto(AccountDto accountDto) {
		this.id = accountDto.getId();
		this.name = accountDto.getName();
		this.email = accountDto.getEmail();
		this.username = accountDto.getUsername();
		this.password = accountDto.getPassword();
		this.roles = accountDto.getRoles();
		this.deleteFlag = accountDto.getDeleteFlag();
	}
}
