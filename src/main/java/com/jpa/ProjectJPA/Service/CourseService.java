package com.jpa.ProjectJPA.Service;


import com.jpa.ProjectJPA.Model.Course;
import com.jpa.ProjectJPA.Repo.CoursesRepo;
import com.jpa.ProjectJPA.Repo.StudentsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    private final CoursesRepo repoCourse;
    private final StudentsRepo repoStudents;

    @Autowired
    public CourseService(CoursesRepo repoCourse, StudentsRepo repoStudents) {
        this.repoCourse = repoCourse;
        this.repoStudents = repoStudents;
    }


    public List<Course> findAll() {
        return repoCourse.findAll();
    }

    public void add(Course course) {
        repoCourse.save(course);
    }

    public void delete(Long id) {
        repoCourse.deleteById(id);
    }

    public List<Course> getCoursesForStudent(Long studentId) {

        if (!repoStudents.existsById(studentId)) {
            throw new RuntimeException("Student with ID " + studentId + " does not exist!");
        }

        return repoCourse.findByStudentId(studentId);
    }
}
