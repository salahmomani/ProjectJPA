package com.jpa.ProjectJPA.Repo;

import com.jpa.ProjectJPA.Model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TeacherRepo extends JpaRepository<Teacher, Long> {

    @Query(value = "SELECT * FROM teachers WHERE id = :id", nativeQuery = true)
    Teacher findByID(@Param("id") Long id);
}
