package com.jpa.ProjectJPA.DTO;
import lombok.Data;
import java.util.List;
@Data
public class CourseResponseDTO {
    private Long id;
    private String code;
    private String title;
    private List<Long> studentIds;
    private List<Long> teacherIds;
    private List<ExamDTO> exams;
}
