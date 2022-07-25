package net.idrok.Resumes.service.impl;

import net.idrok.Resumes.entity.Experience;
import net.idrok.Resumes.repository.ExperienceRepository;
import net.idrok.Resumes.service.ExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExperienceServiceImpl implements ExperienceService {

    @Autowired
    ExperienceRepository experienceRepository;


    @Override
    public Page<Experience> getAll(Pageable pageable) {
        return experienceRepository.findAll(pageable);
    }

    @Override
    public List<Experience> getAll() {
        return experienceRepository.findAll();
    }

    @Override
    public Experience getById(Long id) {
        return experienceRepository.getById(id);
    }

    @Override
    public Experience create(Experience experience) {
        return experienceRepository.save(experience);
    }

    @Override
    public Experience update(Experience experience) {
        return experienceRepository.save(experience);
    }

    @Override
    public void delete(Experience experience) {
        experienceRepository.delete(experience);
    }

    @Override
    public void deleteById(Long id) {
        experienceRepository.deleteById(id);
    }
}
