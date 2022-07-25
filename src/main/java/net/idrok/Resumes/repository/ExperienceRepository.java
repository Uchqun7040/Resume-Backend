package net.idrok.Resumes.repository;

import net.idrok.Resumes.entity.Contact;
import net.idrok.Resumes.entity.Experience;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExperienceRepository extends JpaRepository<Experience,Long> {
}
