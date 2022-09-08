package com.example.lma.service;

import com.example.lma.model.Company;
import com.example.lma.model.Contact;
import com.example.lma.model.Lifecycle;
import com.example.lma.model.Sector;
import com.example.lma.repos.CompanyRepository;
import com.example.lma.repos.ContactRepository;
import com.example.lma.repos.LifecycleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactServiceImpl implements ContactService{


    @Autowired
    ContactRepository contactRepository;

    @Autowired
    LifecycleRepository lifecycleRepository;

    @Autowired
    CompanyRepository companyRepository;


    @Override
    public Contact saveContact(Contact contact, Long lifecycleId, Long companyId) {

        if (lifecycleId == 0){
            Lifecycle lifecycle=  new Lifecycle();
            lifecycle.setId(lifecycleId);
            Lifecycle savedLifecycle = lifecycleRepository.save(lifecycle);
            contact.setLifecycle(savedLifecycle);
        }
        if (lifecycleRepository.existsById(lifecycleId)) {
            Lifecycle lifecycle = lifecycleRepository.findById(lifecycleId).get();
            contact.setLifecycle(lifecycle);
        }

        if (companyId == 0){
            Company company=  new Company();
            company.setId(companyId);
            Company savedCompany = companyRepository.save(company);
            contact.setCompany(savedCompany);
        }
        if (companyRepository.existsById(companyId)) {
            Company company = companyRepository.findById(companyId).get();
            contact.setCompany(company);
        }

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
