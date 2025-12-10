package com.jpa.ProjectJPA.Controller;

import com.jpa.ProjectJPA.DTO.CourseResponseDTO;
import com.jpa.ProjectJPA.Mapper.CourseMapper;
import com.jpa.ProjectJPA.Model.Course;
import com.jpa.ProjectJPA.Service.CourseService;
import com.jpa.ProjectJPA.Service.ExamService;
import com.jpa.ProjectJPA.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")

public class CourseController {
    private final CourseService courseService;
    private final StudentService studentService;
    private final ExamService examService;
    private final CourseMapper courseMapper;
@Autowired
    public CourseController(CourseService courseService, StudentService studentService, ExamService examService, CourseMapper courseMapper) {
        this.courseService = courseService;
        this.studentService = studentService;
        this.examService = examService;
        this.courseMapper = courseMapper;
    }


    @PostMapping("/add")
    public void add(@RequestBody Course course) {

        courseService.add(course);
    }

    @GetMapping("/getAll")
    public List<CourseResponseDTO> findAll() {
        return courseService.findAll().stream().map(courseMapper::toDTO).toList();
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        courseService.delete(id);
    }
    @GetMapping("/student/{studentId}/courses")
    public List<Course> getCoursesForStudent(@PathVariable Long studentId) {
        return courseService.getCoursesForStudent(studentId);
    }

}
