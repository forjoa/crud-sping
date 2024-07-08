package com.crud.contactlistapi.controller;

import com.crud.contactlistapi.entity.Contact;
import com.crud.contactlistapi.services.ContactService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RequestMapping("/api/contacts")
@RestController
public class ContactController {

    private final ContactService contactService;

    @GetMapping
    public Iterable<Contact> list() {
        return contactService.findAll();
    }

    @GetMapping("{id}")
    public Contact get(@PathVariable Integer id) {
        return contactService.findById(id);
    }

    @PostMapping
    public Contact create(@RequestBody Contact contact) {
        return contactService.create(contact);
    }

    @PutMapping("{id}")
    public Contact update(@PathVariable Integer id,
                          @RequestBody Contact contact) {
        return contactService.update(id, contact);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id) {
        contactService.delete(id);
    }
}
