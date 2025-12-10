package com.jpa.ProjectJPA.Mapper;

import com.jpa.ProjectJPA.DTO.*;
import com.jpa.ProjectJPA.Model.*;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class TeacherMapper {

    public TeacherResponseDTO toDTO(Teacher teacher) {
        TeacherResponseDTO dto = new TeacherResponseDTO();
        dto.setId(teacher.getId());
        dto.setName(teacher.getName());
        dto.setEmail(teacher.getEmail());

        dto.setCourses(
                teacher.getCourses().stream()
                        .map(CourseMapper::toCourseDTO)
                        .collect(Collectors.toList())
        );

        return dto;
    }

}
