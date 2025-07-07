package com.universitysystem.classroomservice.infrastructure.adapter;

import com.universitysystem.classroomservice.application.port.out.ClassroomRepositoryPort;
import com.universitysystem.classroomservice.domain.model.Classroom;
import com.universitysystem.classroomservice.infrastructure.repository.ClassroomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ClassroomRepositoryAdapter implements ClassroomRepositoryPort {

    private final ClassroomRepository classroomRepository;

    @Override
    public Classroom save(Classroom classroom) {
        return classroomRepository.save(classroom);
    }

    @Override
    public List<Classroom> findAll() {
        return classroomRepository.findAll();
    }

    @Override
    public Optional<Classroom> findById(Long id) {
        return classroomRepository.findById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return classroomRepository.existsById(id);
    }

    @Override
    public void deleteById(Long id) {
        classroomRepository.deleteById(id);
    }
}
