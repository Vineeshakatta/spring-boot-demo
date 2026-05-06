package com.vineesha.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vineesha.demo.entity.StudentTeacher;

@Repository
public interface StudentTeacherRepository extends JpaRepository<StudentTeacher, Long> {

	List<StudentTeacher> findByStudent_Id(Long studentId);
}
