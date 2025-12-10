package com.jpa.ProjectJPA.DTO;
import lombok.Data;
import java.util.List;
@Data
public class TeacherRequestDTO {
    private String name;
    private String email;
    private List<Long> courseIds;
}
