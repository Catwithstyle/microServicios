package com.universitysystem.classroomservice.application.port.in;

import com.universitysystem.classroomservice.application.dto.ClassroomDto;

import java.util.List;

public interface ClassroomService {
    ClassroomDto createClassroom(ClassroomDto dto);
    List<ClassroomDto> getAllClassrooms();
    ClassroomDto getClassroomById(Long id);
    ClassroomDto updateClassroom(Long id, ClassroomDto dto);
    void deleteClassroom(Long id);
}
