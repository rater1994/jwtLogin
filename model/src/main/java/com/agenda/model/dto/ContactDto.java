package com.agenda.model.dto;

import com.agenda.model.entity.Account;

public class ContactDto {

    private Long id;
    private String firstNameDto;
    private String lastNameDto;
    private String numberPhoneDto;
    private Account accountDtoId;

    public Account getAccountDtoId() {
        return accountDtoId;
    }

    public void setAccountDtoId(Account accountDtoId) {
        this.accountDtoId = accountDtoId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstNameDto() {
        return firstNameDto;
    }

    public void setFirstNameDto(String firstNameDto) {
        this.firstNameDto = firstNameDto;
    }

    public String getLastNameDto() {
        return lastNameDto;
    }

    public void setLastNameDto(String lastNameDto) {
        this.lastNameDto = lastNameDto;
    }

    public String getNumberPhoneDto() {
        return numberPhoneDto;
    }

    public void setNumberPhoneDto(String numberPhoneDto) {
        this.numberPhoneDto = numberPhoneDto;
    }


}
