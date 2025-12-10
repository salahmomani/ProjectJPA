package com.jpa.ProjectJPA.Controller;


import com.jpa.ProjectJPA.DTO.ExamResponseDTO;
import com.jpa.ProjectJPA.Mapper.ExamMapper;
import com.jpa.ProjectJPA.Model.Exam;
import com.jpa.ProjectJPA.Service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/exam")
public class ExamController {

    private final ExamService examService;
    private final ExamMapper examMapper;

    @Autowired
    public ExamController(ExamService examService, ExamMapper examMapper) {
        this.examService = examService;
        this.examMapper = examMapper;
    }


    @PostMapping("/add")
    public String addExam(@RequestBody Exam exam) {
        examService.add(exam);
        return "Exam Added Successfully!";
    }

    @GetMapping("/all")
    public List<ExamResponseDTO> getAll() {
        return examService.getAll().stream().map(examMapper::toDTO).toList();
    }

    @GetMapping("/course/{courseId}")
    public List<Exam> getByCourse(@PathVariable Long courseId) {
        return examService.getByCourseId(courseId);
    }

    @GetMapping("/student/{studentId}")
    public List<Exam> getByStudent(@PathVariable Long studentId) {
        return examService.getByStudent(studentId);
    }


    @PutMapping("/edit")
    public void update(@RequestBody Exam exam) {
        examService.update(exam);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        examService.delete(id);
    }
}
