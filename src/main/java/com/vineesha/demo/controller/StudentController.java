package com.vineesha.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vineesha.demo.entity.Student;
import com.vineesha.demo.entity.Teacher;
import com.vineesha.demo.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {
	
	private static final Logger logger = LoggerFactory.getLogger(StudentController.class);
	
	private final StudentService studentService;
	
	public StudentController(StudentService studentService) {
		this.studentService = studentService;
	}
	
	@PostMapping
	public ResponseEntity<Student> createStudent(@RequestBody Student student) {
		return ResponseEntity.ok(studentService.create(student));
	}
	
	@GetMapping("/")
	public List<Student> getAllStudents() {
		return studentService.getAllStudents();
	}
	
	@GetMapping("/{id}")
	public Student getStudentById(@PathVariable Long id) {
		return studentService.getStudentById(id);
	}
	
	@PutMapping("/{id}")
	public Student update(@PathVariable Long id, @RequestBody Student stu) {
		return studentService.updateStudentById(id, stu);
	}
	
	@GetMapping("/teachers/{id}")
	public List<Teacher> getTeachersList(@PathVariable Long id) {
		return studentService.getTeachersByStudentId(id);
	}
	
	@DeleteMapping("/id")
	public void deleteStudent(@PathVariable Long id) {
		studentService.deleteStudentById(id);
	}
	

}
