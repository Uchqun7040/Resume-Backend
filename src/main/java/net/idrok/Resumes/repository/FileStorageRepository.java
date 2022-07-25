package net.idrok.Resumes.repository;

import net.idrok.Resumes.entity.Contact;
import net.idrok.Resumes.entity.FileStatus;
import net.idrok.Resumes.entity.FileStorage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FileStorageRepository extends JpaRepository<FileStorage,Long> {
    FileStorage findByHashId(String hashId);
    List<FileStorage> findAllByStatus(FileStatus status);
}
