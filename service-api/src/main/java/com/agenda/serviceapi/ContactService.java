package com.agenda.serviceapi;

import com.agenda.model.dto.ContactDto;
import com.agenda.model.entity.Contact;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public interface ContactService {

   List<ContactDto> getAllContactDTO();

   ContactDto addNewContactDTO(@RequestBody ContactDto contactDto);

   ContactDto getContactDTO(@PathVariable Long id);

   ContactDto editContactDTO(@RequestBody ContactDto contactDto, @PathVariable Long id);
}
