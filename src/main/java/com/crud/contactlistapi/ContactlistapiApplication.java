package com.crud.contactlistapi;

import com.crud.contactlistapi.entity.Contact;
import com.crud.contactlistapi.repositories.ContactRespository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class ContactlistapiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ContactlistapiApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(ContactRespository contactRespository) {
        return (String... args) -> {
            List<Contact> contacts = Arrays.asList(
                    new Contact("Carlos", "carlos@gmail.com", LocalDateTime.now()),
                    new Contact("Juan", "juan@gmail.com", LocalDateTime.now()),
                    new Contact("Marcelo", "marcelo@gmail.com", LocalDateTime.now()),
                    new Contact("Luis", "luis@gmail.com", LocalDateTime.now())
            );
            contactRespository.saveAll(contacts);
        };
    }
}
