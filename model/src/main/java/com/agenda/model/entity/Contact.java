package com.agenda.model.entity;


import com.agenda.model.dto.ContactDto;

import javax.persistence.*;

@Entity
public class Contact {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Long id;

	@Column(name = "First_Name")
	private String firstName;

	@Column(name = "Last_Name")
	private String lastName;

	@Column(name = "Number_phone")
	private String numberPhone;

	@ManyToOne(fetch = FetchType.EAGER)
	private Account account;

	public ContactDto toContactDto() {
		ContactDto contactDto = new ContactDto();

		contactDto.setId( this.id );
		contactDto.setFirstNameDto( this.firstName );
		contactDto.setLastNameDto( this.lastName );
		contactDto.setNumberPhoneDto( this.numberPhone );
		contactDto.setAccountDtoId(this.account);
		return contactDto;
	}

	public void updateContactDto(ContactDto contactDto) {
		this.id = contactDto.getId();
		this.firstName = contactDto.getFirstNameDto();
		this.lastName = contactDto.getLastNameDto();
		this.numberPhone = contactDto.getNumberPhoneDto();
        this.account = contactDto.getAccountDtoId();

	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getNumberPhone() {
		return numberPhone;
	}

	public void setNumberPhone(String numberPhone) {
		this.numberPhone = numberPhone;
	}
}
