package com.universitysystem.classroomservice.infrastructure.controller;

import com.universitysystem.classroomservice.application.dto.ClassroomDto;
import com.universitysystem.classroomservice.application.port.in.ClassroomService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/classrooms")
@RequiredArgsConstructor
public class ClassroomController {

    private final ClassroomService classroomService;

    @PostMapping
    public ResponseEntity<ClassroomDto> create(@RequestBody ClassroomDto dto) {
        ClassroomDto created = classroomService.createClassroom(dto);
        return ResponseEntity.ok(created);
    }

    @GetMapping
    public ResponseEntity<List<ClassroomDto>> getAll() {
        List<ClassroomDto> classrooms = classroomService.getAllClassrooms();
        return ResponseEntity.ok(classrooms);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClassroomDto> getById(@PathVariable Long id) {
        ClassroomDto dto = classroomService.getClassroomById(id);
        return ResponseEntity.ok(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClassroomDto> update(@PathVariable Long id, @RequestBody ClassroomDto dto) {
        ClassroomDto updated = classroomService.updateClassroom(id, dto);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        classroomService.deleteClassroom(id);
        return ResponseEntity.noContent().build();
    }
}
