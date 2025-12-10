package com.jpa.ProjectJPA.Service;


import com.jpa.ProjectJPA.Model.Exam;
import com.jpa.ProjectJPA.Repo.ExamRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamService {

    private final ExamRepo repoExam;

    @Autowired
    public ExamService(ExamRepo repoExam) {
        this.repoExam = repoExam;
    }

    public void add(Exam exam) {
        repoExam.save(exam);
    }

    public List<Exam> getAll() {
        return repoExam.findAll();
    }

    public List<Exam> getByCourseId(Long courseId) {
        return repoExam.findByCourse_Id(courseId);
    }

    public List<Exam> getByStudent(Long studentId) {
        return repoExam.findByCourse_Id(studentId);
    }

    public void update(Exam exam) {
        repoExam.save(exam);
    }

    public void delete(Long id) {
        repoExam.deleteById(id);
    }
}
