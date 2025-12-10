package com.jpa.ProjectJPA.DTO;
import lombok.Data;
@Data
public class MarkResponseDTO {
    private Long id;
    private int score;
    private String grade;
    private Long studentId;
    private Long examId;
}
