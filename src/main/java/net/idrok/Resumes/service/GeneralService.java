package net.idrok.Resumes.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface GeneralService<Entity,Long> {
    Page<Entity> getAll(Pageable pageable);
    List<Entity> getAll();
    Entity getById(Long id);
    Entity create(Entity entity);
    Entity update(Entity entity);
    void delete(Entity entity);
    void deleteById(Long id);

}
