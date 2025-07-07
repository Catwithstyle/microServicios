package com.universitysystem.classroomservice.application.mapper;

import com.universitysystem.classroomservice.application.dto.ClassroomDto;
import com.universitysystem.classroomservice.domain.model.Classroom;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-06-11T16:24:43-0600",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.12.jar, environment: Java 22.0.1 (Oracle Corporation)"
)
@Component
public class ClassroomMapperImpl implements ClassroomMapper {

    @Override
    public ClassroomDto toDto(Classroom classroom) {
        if ( classroom == null ) {
            return null;
        }

        ClassroomDto classroomDto = new ClassroomDto();

        classroomDto.setId( classroom.getId() );
        classroomDto.setCode( classroom.getCode() );
        classroomDto.setCapacity( classroom.getCapacity() );
        classroomDto.setType( classroom.getType() );

        return classroomDto;
    }

    @Override
    public Classroom toEntity(ClassroomDto dto) {
        if ( dto == null ) {
            return null;
        }

        Classroom.ClassroomBuilder classroom = Classroom.builder();

        classroom.id( dto.getId() );
        classroom.code( dto.getCode() );
        classroom.capacity( dto.getCapacity() );
        classroom.type( dto.getType() );

        return classroom.build();
    }

    @Override
    public List<ClassroomDto> toDtoList(List<Classroom> classrooms) {
        if ( classrooms == null ) {
            return null;
        }

        List<ClassroomDto> list = new ArrayList<ClassroomDto>( classrooms.size() );
        for ( Classroom classroom : classrooms ) {
            list.add( toDto( classroom ) );
        }

        return list;
    }
}
