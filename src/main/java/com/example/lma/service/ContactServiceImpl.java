package com.example.lma.service;

import com.example.lma.model.Contact;
import com.example.lma.repos.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactServiceImpl implements ContactService{


    @Autowired
    ContactRepository contactRepository;


    @Override
    public Contact saveContact(Contact contact) {
        return contactRepository.save(contact);
    }

    @Override
    public Contact updateContact(Contact contact) {
        return contactRepository.save(contact);
    }

    @Override
    public void deleteContact(Contact contact) {

    }

    @Override
    public void deleteContactById(Long id) {
        contactRepository.deleteById(id);
    }

    @Override
    public Contact getContact(Long id) {
        return contactRepository.findById(id).get();
    }

    @Override
    public List<Contact> getAllContacts() {
        return contactRepository.findAll();
    }
}
