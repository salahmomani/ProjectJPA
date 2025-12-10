package com.jpa.ProjectJPA.Service;

import com.jpa.ProjectJPA.DTO.MarkRequestDTO;
import com.jpa.ProjectJPA.Model.Exam;
import com.jpa.ProjectJPA.Model.Mark;
import com.jpa.ProjectJPA.Model.Student;
import com.jpa.ProjectJPA.Repo.ExamRepo;
import com.jpa.ProjectJPA.Repo.MarkRepo;
import com.jpa.ProjectJPA.Repo.StudentsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MarkService {

    private final MarkRepo markRepo;
    private final StudentsRepo studentRepository;
    private final ExamRepo examRepository;

    @Autowired
    public MarkService(
            MarkRepo markRepo,
            StudentsRepo studentRepository,
            ExamRepo examRepository) {
        this.markRepo = markRepo;
        this.studentRepository = studentRepository;
        this.examRepository = examRepository;
    }

    public Mark addMark(MarkRequestDTO dto) {

        Student student = studentRepository.findById(dto.getStudentId())
                .orElseThrow(() -> new RuntimeException("Student not found"));

        Exam exam = examRepository.findById(dto.getExamId())
                .orElseThrow(() -> new RuntimeException("Exam not found"));

        Mark mark = new Mark();
        mark.setScore(dto.getScore());
        mark.setGrade(dto.getGrade());
        mark.setStudent(student);
        mark.setExam(exam);

         markRepo.save(mark);
        return mark;
    }

    public List<Mark> findAll() {
        return markRepo.findAll();
    }

    public void delete(Long id) {
        markRepo.deleteById(id);
    }
}
