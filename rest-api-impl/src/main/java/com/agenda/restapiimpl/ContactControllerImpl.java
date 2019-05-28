package com.agenda.restapiimpl;

import com.agenda.model.dto.ContactDto;
import com.agenda.model.entity.Contact;
import com.agenda.model.repository.ContactRepository;
import com.agenda.restapi.Contact.ContactsController;
import com.agenda.serviceapi.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ContactControllerImpl implements ContactsController {

    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private ContactService contactService;

    public ContactControllerImpl(ContactRepository contactRepository, ContactService contactService) {
    this.contactRepository = contactRepository;
    this.contactService = contactService;
    }

    @Override
    public List<ContactDto> getContacts() {
        return contactService.getAllContactDTO();
    }

    @Override
    public ContactDto addContact(@RequestBody ContactDto contactDto) {
        return contactService.addNewContactDTO(contactDto);
    }

    @Override
    public ContactDto getContact(@PathVariable Long id) {
            return contactService.getContactDTO(id);
    }

    @Override
    public ContactDto editContact(@RequestBody ContactDto contactDto,@PathVariable Long id) {
       return contactService.editContactDTO(contactDto, id);
    }


}
