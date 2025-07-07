package com.universitysystem.classroomservice.application.service.impl;

import com.universitysystem.classroomservice.application.dto.ClassroomDto;
import com.universitysystem.classroomservice.application.mapper.ClassroomMapper;
import com.universitysystem.classroomservice.application.port.in.ClassroomService;
import com.universitysystem.classroomservice.application.port.out.ClassroomRepositoryPort;
import com.universitysystem.classroomservice.domain.model.Classroom;
import com.universitysystem.classroomservice.infrastructure.exception.ClassroomNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClassroomServiceImpl implements ClassroomService {

    private final ClassroomRepositoryPort repository;
    private final ClassroomMapper mapper;

    @Override
    public ClassroomDto createClassroom(ClassroomDto dto) {
        Classroom classroom = mapper.toEntity(dto);
        return mapper.toDto(repository.save(classroom));
    }

    @Override
    public List<ClassroomDto> getAllClassrooms() {
        return mapper.toDtoList(repository.findAll());
    }

    @Override
    public ClassroomDto getClassroomById(Long id) {
        Classroom classroom = repository.findById(id)
                .orElseThrow(() -> new ClassroomNotFoundException("Aula no encontrada con ID: " + id));
        return mapper.toDto(classroom);
    }

    @Override
    public ClassroomDto updateClassroom(Long id, ClassroomDto dto) {
        Classroom existing = repository.findById(id)
                .orElseThrow(() -> new ClassroomNotFoundException("Aula no encontrada con ID: " + id));

        existing.setCode(dto.getCode());
        existing.setCapacity(dto.getCapacity());
        existing.setType(dto.getType());

        return mapper.toDto(repository.save(existing));
    }

    @Override
    public void deleteClassroom(Long id) {
        if (!repository.existsById(id)) {
            throw new ClassroomNotFoundException("No se puede eliminar. Aula no encontrada con ID: " + id);
        }
        repository.deleteById(id);
    }
}
