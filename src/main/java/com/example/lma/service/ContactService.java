package com.example.lma.service;

import com.example.lma.model.Contact;

import java.util.List;

public interface ContactService {
    Contact saveContact(Contact contact, Long lifecycleId);
    Contact updateContact(Contact contact);
    void deleteContact(Contact contact);
    void deleteContactById(Long id);
    Contact getContact(Long id);
    List<Contact> getAllContacts();
}
