package com.estudo.agendaSpring.controller;

import com.estudo.agendaSpring.model.Contact;
import com.estudo.agendaSpring.repository.ContactRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contacts")
public class ContactController {

    private final ContactRepository contactRepository;

    public ContactController(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @GetMapping
    public List<Contact> getAllContacts(){
        return contactRepository.findAll();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity getContactById(@PathVariable Long id){
     return contactRepository.findById(id)
             .map(contact -> ResponseEntity.ok()
                     .body(contact))
             .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Contact postContact(@RequestBody Contact contact){
        return  contactRepository.save(contact);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity updateContact(@PathVariable Long id, @RequestBody Contact contact){
        return contactRepository.findById(id)
                .map(c -> {
                    c.setEmail(contact.getEmail());
                    c.setName(contact.getName());
                    c.setPhone(contact.getPhone());
                    Contact update = contactRepository.save(c);
                    return  ResponseEntity.ok().body(update);
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity deleteContact(@PathVariable Long id){
        return contactRepository.findById(id).map(contact -> {
            contactRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }).orElse(ResponseEntity.notFound().build());
    }
}
