package net.idrok.Resumes.controller;

import net.idrok.Resumes.entity.Experience;
import net.idrok.Resumes.entity.Resume;
import net.idrok.Resumes.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/resume/")
public class ResumeController {
    @Autowired
    ResumeService resumeService;

    @GetMapping
    public Page<Resume> getAll(Pageable pageable){
        return resumeService.getAll(pageable);
    }


    @PutMapping
    public Resume update(@RequestBody Resume resume){
        return resumeService.update(resume);
    }

    @PostMapping
    public Resume create(@RequestBody Resume resume){
        return resumeService.create(resume);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        resumeService.deleteById(id);
    }

    @GetMapping("/getOne/{id}")
    public Resume getById(@PathVariable Long id){
        return resumeService.getById(id);
    }


}
