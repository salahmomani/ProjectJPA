package com.jpa.ProjectJPA.DTO;
import lombok.Data;
@Data
public class MarkRequestDTO {
    private Integer score;
    private String grade;
    private Long studentId;
    private Long examId;
}
