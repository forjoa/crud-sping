package com.crud.contactlistapi.controller;

import com.crud.contactlistapi.entity.Contact;
import com.crud.contactlistapi.repositories.ContactRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RequestMapping("/api/contacts")
@RestController
public class ContactController {
    @Autowired
    private ContactRespository contactRespository;

    @GetMapping
    public Iterable<Contact> list() {
        return contactRespository.findAll();
    }

    @GetMapping("{id}")
    public Contact get(@PathVariable Integer id) {
        return contactRespository.findById(id).orElse(null);
    }

    @PostMapping
    public Contact create(@RequestBody Contact contact) {
        contact.setCreatedAt(LocalDateTime.now());
        return contactRespository.save(contact);
    }

    @PutMapping("{id}")
    public Contact update(@PathVariable Integer id,
                          @RequestBody Contact contact) {
        Contact contactFromDb = contactRespository.findById(id).orElse(null);

        contactFromDb.setName(contact.getName());
        contactFromDb.setEmail(contact.getEmail());

        return contactRespository.save(contactFromDb);
    }
}
