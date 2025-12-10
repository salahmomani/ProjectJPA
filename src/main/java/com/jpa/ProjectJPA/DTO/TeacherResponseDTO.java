package com.jpa.ProjectJPA.DTO;
import lombok.Data;
import java.util.List;
@Data
public class TeacherResponseDTO {
    private Long id;
    private String name;
    private String email;
    private List<CourseDTO> courses;
}
