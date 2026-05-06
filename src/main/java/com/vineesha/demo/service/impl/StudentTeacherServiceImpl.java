package com.vineesha.demo.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.vineesha.demo.entity.Student;
import com.vineesha.demo.entity.StudentTeacher;
import com.vineesha.demo.entity.Teacher;
import com.vineesha.demo.repository.StudentRepository;
import com.vineesha.demo.repository.StudentTeacherRepository;
import com.vineesha.demo.repository.TeacherRepository;
import com.vineesha.demo.service.StudentTeacherService;

@Service
public class StudentTeacherServiceImpl implements StudentTeacherService {
	
	private static final Logger logger = LoggerFactory.getLogger(StudentServiceImpl.class);
	
	private final StudentRepository stuRepo;
	
	private final TeacherRepository teaRepo;
	
	private final StudentTeacherRepository stuTeaRepo;
	
	public StudentTeacherServiceImpl(StudentRepository stuRepo, TeacherRepository teaRepo, StudentTeacherRepository stuTeaRepo) {
		this.stuRepo = stuRepo;
		this.teaRepo = teaRepo;
		this.stuTeaRepo = stuTeaRepo;
	}
	
	public StudentTeacher create(Long stuId, Long teaId) {
		Student stu = stuRepo.findById(stuId)
				.orElseThrow(() -> new RuntimeException("Student doesn't exists with {stuId}"));
		Teacher tea = teaRepo.findById(teaId)
				.orElseThrow(() -> new RuntimeException("Teacher doesn't exists with {teaId}"));
		StudentTeacher stuTea = new StudentTeacher();
		stuTea.setStudent(stu);
		stuTea.setTeacher(tea);
		return stuTeaRepo.save(stuTea);
	}

}
