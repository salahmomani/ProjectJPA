package com.jpa.ProjectJPA.Model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String code;

    private String title;

    @ManyToMany(mappedBy = "courses")
    private List<Student> students = new ArrayList<>();

    @ManyToMany(mappedBy = "courses")
    private List<Teacher> teachers = new ArrayList<>();

    @OneToMany(mappedBy = "course")
    private List<Exam> exams = new ArrayList<>();
}
