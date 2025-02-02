package com.crud.contactlistapi.services;

import com.crud.contactlistapi.entity.Contact;
import com.crud.contactlistapi.repositories.ContactRespository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@AllArgsConstructor
@Service
public class ContactService {

    private final ContactRespository contactRespository;

    public Iterable<Contact> findAll() {
        return contactRespository.findAll();
    }

    public Contact findById(Integer id) {
        return contactRespository.findById(id).orElse(null);
    }

    public Contact create(Contact contact) {
        contact.setCreatedAt(LocalDateTime.now());
        return contactRespository.save(contact);
    }

    public Contact update(Integer id, Contact contact) {
        Contact contactFromDb = findById(id);

        contactFromDb.setName(contact.getName());
        contactFromDb.setEmail(contact.getEmail());

        return contactRespository.save(contactFromDb);
    }

    public void delete(Integer id) {
        Contact contactFromDb = findById(id);
        contactRespository.delete(contactFromDb);
    }
}
