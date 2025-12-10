package com.jpa.ProjectJPA.DTO;
import lombok.Data;
import java.util.List;
@Data
public class StudentRequestDTO {
    private String name;
    private String email;
    private List<Long> courseIds;   // many-to-many
}