package com.jpa.ProjectJPA.Mapper;

import com.jpa.ProjectJPA.DTO.*;
import com.jpa.ProjectJPA.Model.*;
import org.springframework.stereotype.Component;

@Component
public class MarkMapper {

    public MarkResponseDTO toDTO(Mark mark) {
        MarkResponseDTO dto = new MarkResponseDTO();
        dto.setId(mark.getId());
        dto.setScore(mark.getScore());
        dto.setGrade(mark.getGrade());
        dto.setStudentId(mark.getStudent().getId());
        dto.setExamId(mark.getExam().getId());
        return dto;
    }

    public static MarkDTO toMarkDTO(Mark mark) {
        MarkDTO dto = new MarkDTO();
        dto.setId(mark.getId());
        dto.setScore(mark.getScore());
        dto.setGrade(mark.getGrade());
        return dto;
    }


}
