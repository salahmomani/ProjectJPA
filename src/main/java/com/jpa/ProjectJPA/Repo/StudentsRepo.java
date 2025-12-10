package com.jpa.ProjectJPA.Repo;

import com.jpa.ProjectJPA.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface StudentsRepo extends JpaRepository<Student, Long> {

    @Query(value = "SELECT * FROM students WHERE id = :id", nativeQuery = true)
    Student findByID(@Param("id") Long id);
}
