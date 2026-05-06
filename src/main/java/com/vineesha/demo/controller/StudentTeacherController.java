package com.vineesha.demo.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vineesha.demo.entity.StudentTeacher;
import com.vineesha.demo.service.StudentTeacherService;

@RestController
@RequestMapping("/studentteacher")
public class StudentTeacherController {
	
	private static final Logger logger = LoggerFactory.getLogger(StudentTeacherController.class);
	
	private final StudentTeacherService stuteaService;
	
	public StudentTeacherController(StudentTeacherService stuteaService) {
		this.stuteaService = stuteaService;
	}
	
	@PostMapping
	public ResponseEntity<StudentTeacher> create(@RequestBody Map<String, Long> req) {
		return ResponseEntity.ok(stuteaService.create(req.get("studentId"), req.get("teacherId")));
	}

}
