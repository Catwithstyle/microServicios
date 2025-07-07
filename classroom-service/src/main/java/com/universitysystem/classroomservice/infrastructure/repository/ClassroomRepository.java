package com.universitysystem.classroomservice.infrastructure.repository;

import com.universitysystem.classroomservice.domain.model.Classroom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassroomRepository extends JpaRepository<Classroom, Long> {
}
