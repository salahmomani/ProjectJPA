package com.jpa.ProjectJPA.Repo;

import com.jpa.ProjectJPA.Model.Mark;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MarkRepo extends JpaRepository<Mark, Long> {

    List<Mark> findByStudent_Id(Long studentId);
    List<Mark> findByExam_Id(Long examId);
}
