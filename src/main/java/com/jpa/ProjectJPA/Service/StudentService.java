package com.jpa.ProjectJPA.Service;

import com.jpa.ProjectJPA.Model.Student;
import com.jpa.ProjectJPA.Repo.StudentsRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {


    private final StudentsRepo repoStudents;

    public StudentService(StudentsRepo repoStudents) {
        this.repoStudents = repoStudents;
    }

    public List<Student> findAll() {
        return repoStudents.findAll();
    }

    public void add(Student student) {
        repoStudents.save(student);
    }

    public Student findByID(Long id) {
        return repoStudents.findByID(id);
    }

    public void update(Student student) {
        repoStudents.save(student);
    }

    public void delete(Long id) {
        repoStudents.deleteById(id);
    }
}
