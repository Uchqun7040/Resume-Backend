package net.idrok.Resumes.repository;

import net.idrok.Resumes.entity.Contact;
import net.idrok.Resumes.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    User findByUserName(String username);
    Boolean existsByUserName(String username);
}
