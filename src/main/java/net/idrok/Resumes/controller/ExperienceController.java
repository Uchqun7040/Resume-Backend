package net.idrok.Resumes.controller;

import net.idrok.Resumes.entity.Education;
import net.idrok.Resumes.entity.Experience;
import net.idrok.Resumes.service.ExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/experience/")
public class ExperienceController {
    @Autowired
    ExperienceService experienceService;

    @GetMapping
    public List<Experience> getAll(){
        return experienceService.getAll();
    }


    @PutMapping
    public Experience update(@RequestBody Experience experience){
        return experienceService.update(experience);
    }

    @PostMapping
    public Experience create(@RequestBody Experience experience){
        return experienceService.create(experience);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        experienceService.deleteById(id);
    }


}
