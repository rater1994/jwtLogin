package com.agenda.serviceapiimpl;

import com.agenda.model.dto.ContactDto;
import com.agenda.model.entity.Contact;
import com.agenda.model.repository.ContactRepository;
import com.agenda.serviceapi.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactRepository contactRepository;

    @Override
    public List<ContactDto> getAllContactDTO() {
        List<ContactDto> listContactDto = new ArrayList<>();
        contactRepository.findAll().forEach(contact -> {
            listContactDto.add(contact.toContactDto());
        });
        return listContactDto;
    }

    @Override
    public ContactDto addNewContactDTO(ContactDto contactDto) {
        Contact contact = new Contact();
        contact.updateContactDto(contactDto);
        return  contactRepository.save(contact).toContactDto();
    }

    @Override
    public ContactDto getContactDTO(Long id) {
        if (contactRepository.findById(id).isPresent()) {
            return contactRepository.findById(id).get().toContactDto();
        }
        return null;
    }

    @Override
    public ContactDto editContactDTO(ContactDto contactDto, Long id) {
        Optional<Contact> dbContact = contactRepository.findById(id);

        if (dbContact.isPresent()) {
            Contact contact = dbContact.get();

            contact.setFirstName(contactDto.getFirstNameDto());
            contact.setLastName(contactDto.getLastNameDto());
            contact.setNumberPhone(contactDto.getNumberPhoneDto());
            return contactRepository.save(contact).toContactDto();

        } else {
            return null;
        }
    }

}
