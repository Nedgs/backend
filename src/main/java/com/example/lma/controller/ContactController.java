package com.example.lma.controller;

import com.example.lma.model.Company;
import com.example.lma.model.Contact;
import com.example.lma.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pros")
@CrossOrigin(origins = "*")
public class ContactController {

    @Autowired
    ContactService contactService;

    @GetMapping("/contacts")
    List<Contact> getAllContacts() {
        return contactService.getAllContacts();
    }

    @GetMapping("/contact/{id}")
    public Contact getContactById(@PathVariable("id") Long id){

        return contactService.getContact(id);
    }

    @PostMapping("/contact/save")
    public Contact createContact(@RequestBody Contact contact, @RequestParam Long lifecycleId, @RequestParam Long companyId) {
        return contactService.saveContact(contact, lifecycleId, companyId);
    }

    @PutMapping ("/contact/save")
    public Contact updateContact(@RequestBody Contact contact) {
        return contactService.updateContact(contact);
    }

    @DeleteMapping("/contact/delete/{id}")
    public  void deleteContact(@PathVariable("id") Long id){

        contactService.deleteContactById(id);
    }
}
