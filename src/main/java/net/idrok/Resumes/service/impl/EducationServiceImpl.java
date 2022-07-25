package net.idrok.Resumes.service.impl;

import net.idrok.Resumes.entity.Education;
import net.idrok.Resumes.repository.EducationRepository;
import net.idrok.Resumes.service.EducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class EducationServiceImpl implements EducationService {
    @Autowired
    EducationRepository educationRepository;

    @Override
    public Page<Education> getAll(Pageable pageable) {
        return educationRepository.findAll(pageable);
    }

    @Override
    public List<Education> getAll() {

        return educationRepository.findAll();
    }

    @Override
    public Education getById(Long id) {

        return educationRepository.getById(id);
    }

    @Override
    public Education create(Education education) {
        return educationRepository.save(education);
    }

    @Override
    public Education update(Education education) {
        return educationRepository.save(education);
    }

    @Override
    public void delete(Education education) {
        educationRepository.delete(education);
    }

    @Override
    public void deleteById(Long id) {
        educationRepository.deleteById(id);
    }
}
