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

import com.vineesha.demo.entity.Teacher;
import com.vineesha.demo.service.TeacherService;

@RestController
@RequestMapping("/teachers")
public class TeacherController {

	
	private static final Logger logger = LoggerFactory.getLogger(TeacherController.class);
	
	private final TeacherService teacherService;
	
	public TeacherController(TeacherService teacherService) {
		this.teacherService = teacherService;
	}
	
	@GetMapping("/")
	public List<Teacher> getAllTeachers() {
		return teacherService.getAllTeachers();
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Teacher> getTeacherById(@PathVariable Long id) {
		return ResponseEntity.ok(teacherService.getTeacherById(id));
	}
	
	@PostMapping
	public ResponseEntity<Teacher> createTeacher(@RequestBody Teacher teacher) {
		return ResponseEntity.ok(teacherService.createTeacher(teacher));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Teacher> updateTeacher(@PathVariable Long id, @RequestBody Teacher teacher) {
		return ResponseEntity.ok(teacherService.updateTeacher(id, teacher));
	}
	
	@DeleteMapping("/{id}")
	public void deleteTeacher(@PathVariable Long id) {
		teacherService.deleteTeacher(id);
	}
}
