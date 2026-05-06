package com.vineesha.demo.service;

import java.util.List;

import com.vineesha.demo.entity.Student;
import com.vineesha.demo.entity.Teacher;

public interface StudentService {

	List<Student> getAllStudents();

	Student getStudentById(Long id);

	Student create(Student student);

	Student updateStudentById(Long id, Student stu);

	List<Teacher> getTeachersByStudentId(Long id);

	void deleteStudentById(Long id);

}
