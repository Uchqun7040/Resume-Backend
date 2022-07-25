package net.idrok.Resumes.service.impl;

import net.idrok.Resumes.entity.Contact;
import net.idrok.Resumes.repository.ContactRepository;
import net.idrok.Resumes.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    ContactRepository contactRepository;


    @Override
    public Page<Contact> getAll(Pageable pageable) {
        return contactRepository.findAll(pageable);
    }

    @Override
    public List<Contact> getAll() {
        return contactRepository.findAll();
    }

    @Override
    public Contact getById(Long id) {
        return contactRepository.getById(id);
    }

    @Override
    public Contact create(Contact contact) {
        return contactRepository.save(contact);
    }

    @Override
    public Contact update(Contact contact) {
        return contactRepository.save(contact);
    }

    @Override
    public void delete(Contact contact) {
        contactRepository.delete(contact);
    }

    @Override
    public void deleteById(Long id) {
        contactRepository.deleteById(id);
    }
}
