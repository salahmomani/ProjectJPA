package com.jpa.ProjectJPA.Repo;

import com.jpa.ProjectJPA.Model.Exam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ExamRepo extends JpaRepository<Exam, Long> {

    List<Exam> findByCourse_Id(Long courseId);

    @Query("SELECT e FROM Exam e JOIN e.marks m WHERE m.student.id = :studentId")
    List<Exam> findByStudentId(@Param("studentId") Long studentId);
}
