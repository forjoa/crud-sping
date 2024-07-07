package com.crud.contactlistapi.repositories;

import com.crud.contactlistapi.entity.Contact;
import org.springframework.data.repository.CrudRepository;

public interface ContactRespository extends CrudRepository<Contact, Integer> {
}
