package com.jpa.ProjectJPA.Mapper;

import com.jpa.ProjectJPA.DTO.*;
import com.jpa.ProjectJPA.Model.*;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class ExamMapper {

    public ExamResponseDTO toDTO(Exam exam) {
        ExamResponseDTO dto = new ExamResponseDTO();
        dto.setId(exam.getId());
        dto.setName(exam.getName());
        dto.setMaxScore(exam.getMaxScore());
        dto.setCourseId(exam.getCourse().getId());

        dto.setMarks(
                exam.getMarks().stream()
                        .map(MarkMapper::toMarkDTO)
                        .collect(Collectors.toList())
        );

        return dto;
    }

    public static ExamDTO toExamDTO(Exam exam) {
        ExamDTO dto = new ExamDTO();
        dto.setId(exam.getId());
        dto.setName(exam.getName());
        dto.setMaxScore(exam.getMaxScore());
        return dto;
    }

}
