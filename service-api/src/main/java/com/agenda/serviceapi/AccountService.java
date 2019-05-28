package com.agenda.serviceapi;

import com.agenda.model.dto.AccountDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public interface AccountService {

    List<AccountDto> getAllAccountsDto();

    AccountDto addAccountDTO(@RequestBody AccountDto accountDto);

    AccountDto editAccountDTO(@RequestBody  AccountDto accountDto, @PathVariable Long id);

    AccountDto findAccountDTO(@PathVariable Long id);

    AccountDto deleteAccountDTO(@PathVariable Long id);
}
