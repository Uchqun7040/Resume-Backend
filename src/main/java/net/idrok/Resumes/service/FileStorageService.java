package net.idrok.Resumes.service;


import net.idrok.Resumes.entity.FileStorage;
import org.springframework.web.multipart.MultipartFile;

public interface FileStorageService{
    public void save(MultipartFile multiFile);

    public void delete(String hashId);

    public FileStorage findByHashId(String hashId);
}
