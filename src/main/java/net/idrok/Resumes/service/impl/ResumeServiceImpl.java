package net.idrok.Resumes.service.impl;

import net.idrok.Resumes.entity.Resume;
import net.idrok.Resumes.repository.ResumeRepository;
import net.idrok.Resumes.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResumeServiceImpl implements ResumeService {
    @Autowired
    ResumeRepository resumeRepository;

    @Override
    public Page<Resume> getAll(Pageable pageable) {
        return resumeRepository.findAll(pageable);
    }

    @Override
    public List<Resume> getAll() {
        return resumeRepository.findAll();
    }

    @Override
    public Resume getById(Long id) {
        return resumeRepository.getById(id);
    }

    @Override
    public Resume create(Resume resume) {
        return resumeRepository.save(resume);
    }

    @Override
    public Resume update(Resume resume) {
        return resumeRepository.save(resume);
    }

    @Override
    public void delete(Resume resume) {
        resumeRepository.delete(resume);
    }

    @Override
    public void deleteById(Long id) {
        resumeRepository.deleteById(id);
    }
}
