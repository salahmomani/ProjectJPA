package com.jpa.ProjectJPA.Controller;

import com.jpa.ProjectJPA.DTO.TeacherResponseDTO;
import com.jpa.ProjectJPA.Mapper.TeacherMapper;
import com.jpa.ProjectJPA.Model.Teacher;
import com.jpa.ProjectJPA.Service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teacher")

public class TeacherController {

    private final TeacherService teacherService;
    private final TeacherMapper teacherMapper;

    @Autowired
    public TeacherController(TeacherService teacherService, TeacherMapper teacherMapper) {
        this.teacherService = teacherService;
        this.teacherMapper = teacherMapper;
    }


    @GetMapping("/getAll")
    public List<TeacherResponseDTO> findAll() {
        return teacherService.findAll().stream().map(teacherMapper::toDTO).toList();
    }

    @PostMapping("/add")
    public void add(@RequestBody Teacher teacher) {
        teacherService.add(teacher);
    }

    @GetMapping("/getByID")
    public TeacherResponseDTO findByID(@PathVariable Long id) {
         Teacher teacher= teacherService.findByID(id);
        return teacherMapper.toDTO(teacher);
    }

    @PutMapping("/update")
    public void update(@RequestBody Teacher teacher) {
        teacherService.update(teacher);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        teacherService.deleteTeacher(id);
    }
}
