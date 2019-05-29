package com.agenda.restapiimpl;

import com.agenda.model.dto.AccountDto;
import com.agenda.restapi.Contact.AccountController;
import com.agenda.serviceapi.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccountControllerImpl implements AccountController {

	@Autowired
	private AccountService accountService;

	@Override
	public List <AccountDto> getAllAccounts() {
		return accountService.getAllAccountsDto();
	}

	@Override
	public AccountDto addAccount(@RequestBody AccountDto accountDto) {
		return accountService.addAccountDTO( accountDto );
	}

	@Override
	public AccountDto editAccount(@RequestBody AccountDto accountDto, @PathVariable Long id) {
		return accountService.editAccountDTO( accountDto, id );
	}

	@Override
	public AccountDto findAccount(@PathVariable Long id) {
		return accountService.findAccountDTO( id );
	}

	@Override
	public AccountDto deleteAccount(@PathVariable Long id) {
		return accountService.deleteAccountDTO( id );
	}

	@Override
	public ResponseEntity<?>  signIn(@RequestBody AccountDto accountDto) {
		return accountService.signInAccountDto( accountDto );
	}

	@Override
	public ResponseEntity<?>  signUp(@RequestBody AccountDto accountDto) {
		return accountService.signUpAccountDto( accountDto );
	}


}
