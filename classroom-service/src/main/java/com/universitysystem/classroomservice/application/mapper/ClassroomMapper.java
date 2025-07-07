package com.universitysystem.classroomservice.application.mapper;

import com.universitysystem.classroomservice.domain.model.Classroom;
import com.universitysystem.classroomservice.application.dto.ClassroomDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClassroomMapper {
    ClassroomDto toDto(Classroom classroom);
    Classroom toEntity(ClassroomDto dto);
    List<ClassroomDto> toDtoList(List<Classroom> classrooms);
}
