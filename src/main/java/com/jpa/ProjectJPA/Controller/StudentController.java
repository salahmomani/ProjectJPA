package com.jpa.ProjectJPA.Controller;


import com.jpa.ProjectJPA.DTO.StudentResponseDTO;
import com.jpa.ProjectJPA.Mapper.StudentMapper;
import com.jpa.ProjectJPA.Model.Student;
import com.jpa.ProjectJPA.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")

public class StudentController {
    private final StudentService studentService;
    private final StudentMapper studentMapper;

    @Autowired
    public StudentController(StudentService studentService, StudentMapper studentMapper) {
        this.studentService = studentService;
        this.studentMapper = studentMapper;
    }


    @GetMapping("/getAll")
    public List<StudentResponseDTO> findAll() {
        return studentService.findAll().stream().map(studentMapper::toDTO).toList();

    }

    @PostMapping("/add")
    public void add(@RequestBody Student student) {
        studentService.add(student);
    }

    @GetMapping("/getByID/{id}")
    public StudentResponseDTO findByID(@PathVariable Long id) {
        Student student = studentService.findByID(id);
        return studentMapper.toDTO(student);
    }

    @PutMapping("/update")
    public void update(@RequestBody Student student) {
        studentService.update(student);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        studentService.delete(id);
    }
}
