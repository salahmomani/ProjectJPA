package com.jpa.ProjectJPA.Service;


import com.jpa.ProjectJPA.Model.Teacher;
import com.jpa.ProjectJPA.Repo.TeacherRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {

    private final TeacherRepo repoTeacher;

    public TeacherService(TeacherRepo repoTeacher) {
        this.repoTeacher = repoTeacher;
    }

    public List<Teacher> findAll() {
        return repoTeacher.findAll();
    }

    public void add(Teacher teacher) {
        repoTeacher.save(teacher);
    }

    public Teacher findByID(Long id) {
        return repoTeacher.findByID(id);
    }

    public void update(Teacher teacher) {
        repoTeacher.save(teacher);
    }

    public void deleteTeacher(Long id) {
        repoTeacher.deleteById(id);
    }
}
