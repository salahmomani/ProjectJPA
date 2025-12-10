package com.jpa.ProjectJPA.Mapper;

import com.jpa.ProjectJPA.DTO.*;
import com.jpa.ProjectJPA.Model.*;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class StudentMapper {
    public StudentResponseDTO toDTO(Student student) {
        StudentResponseDTO dto = new StudentResponseDTO();
        dto.setId(student.getId());
        dto.setName(student.getName());
        dto.setEmail(student.getEmail());

        dto.setCourses(
                student.getCourses().stream()
                        .map(CourseMapper::toCourseDTO)
                        .collect(Collectors.toList())
        );

        return dto;
    }
}
