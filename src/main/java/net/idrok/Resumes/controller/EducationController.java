package net.idrok.Resumes.controller;

import net.idrok.Resumes.entity.Contact;
import net.idrok.Resumes.entity.Education;
import net.idrok.Resumes.service.ContactService;
import net.idrok.Resumes.service.EducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/education/")
public class EducationController {
    @Autowired
    EducationService educationService;

    @GetMapping
    public List<Education> getAll(){
        return educationService.getAll();
    }


    @PutMapping
    public Education update(@RequestBody Education education){
        return educationService.update(education);
    }

    @PostMapping
    public Education create(@RequestBody Education education){
        return educationService.create(education);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        educationService.deleteById(id);
    }


}
