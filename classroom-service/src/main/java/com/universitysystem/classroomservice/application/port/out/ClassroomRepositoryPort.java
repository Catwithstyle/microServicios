package com.universitysystem.classroomservice.application.port.out;

import com.universitysystem.classroomservice.domain.model.Classroom;

import java.util.List;
import java.util.Optional;

public interface ClassroomRepositoryPort {
    Classroom save(Classroom classroom);
    List<Classroom> findAll();
    Optional<Classroom> findById(Long id);
    boolean existsById(Long id);
    void deleteById(Long id);
}
