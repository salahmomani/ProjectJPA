package com.jpa.ProjectJPA.Mapper;

import com.jpa.ProjectJPA.DTO.*;
import com.jpa.ProjectJPA.Model.*;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;
@Component
public class CourseMapper {

    public CourseResponseDTO toDTO(Course course) {
        CourseResponseDTO dto = new CourseResponseDTO();
        dto.setId(course.getId());
        dto.setCode(course.getCode());
        dto.setTitle(course.getTitle());

        dto.setStudentIds(
                course.getStudents().stream()
                        .map(Student::getId)
                        .collect(Collectors.toList())
        );

        dto.setTeacherIds(
                course.getTeachers().stream()
                        .map(Teacher::getId)
                        .collect(Collectors.toList())
        );

        dto.setExams(
                course.getExams().stream()
                        .map(ExamMapper::toExamDTO)
                        .collect(Collectors.toList())
        );

        return dto;
    }

    public static CourseDTO toCourseDTO(Course course) {
        CourseDTO dto = new CourseDTO();
        dto.setId(course.getId());
        dto.setCode(course.getCode());
        dto.setTitle(course.getTitle());
        return dto;
    }

}
