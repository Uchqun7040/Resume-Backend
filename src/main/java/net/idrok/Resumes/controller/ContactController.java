package net.idrok.Resumes.controller;

import net.idrok.Resumes.entity.Contact;
import net.idrok.Resumes.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contact/")
public class ContactController {
    @Autowired
    ContactService contactService;

    @GetMapping
    public List<Contact> getAll(){
        return contactService.getAll();
    }


    @PutMapping
    public Contact update(@RequestBody Contact contact){
        return contactService.update(contact);
    }

    @PostMapping
    public Contact create(@RequestBody Contact contact){
        return contactService.create(contact);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        contactService.deleteById(id);
    }


}
