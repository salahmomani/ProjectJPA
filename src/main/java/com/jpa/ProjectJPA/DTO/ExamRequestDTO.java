package com.jpa.ProjectJPA.DTO;
import lombok.Data;
@Data
public class ExamRequestDTO {
    private String name;
    private int maxScore;
    private Long courseId;
}
