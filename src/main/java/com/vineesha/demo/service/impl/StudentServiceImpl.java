package com.vineesha.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.vineesha.demo.entity.Student;
import com.vineesha.demo.entity.StudentTeacher;
import com.vineesha.demo.entity.Teacher;
import com.vineesha.demo.repository.StudentRepository;
import com.vineesha.demo.repository.StudentTeacherRepository;
import com.vineesha.demo.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
	
	private final StudentRepository studentRepo;
	
	private final StudentTeacherRepository stuTeaRepo;
	
	public StudentServiceImpl(StudentRepository studentRepo, StudentTeacherRepository stuTeaRepo) {
		this.studentRepo = studentRepo;
		this.stuTeaRepo = stuTeaRepo;
	}

	@Override
	public List<Student> getAllStudents() {
		return studentRepo.findAll();
	}

	@Override
	public Student getStudentById(Long id) {
		return studentRepo.findById(id)
				.orElseThrow(() -> new RuntimeException("Student doesn't exist with {id}"));
	}

	@Override
	public Student create(Student student) {
		return studentRepo.save(student);
	}

	@Override
	public Student updateStudentById(Long id, Student stu) {
		Student existing = getStudentById(id);
		existing.setName(stu.getName());
		return studentRepo.save(existing);
	}

	@Override
	public List<Teacher> getTeachersByStudentId(Long id) {
		List<StudentTeacher> stuTea = stuTeaRepo.findByStudent_Id(id);
		return stuTea.stream()
                .map(StudentTeacher::getTeacher)
                .toList();
	}

	@Override
	public void deleteStudentById(Long id) {
		studentRepo.deleteById(id);
	}

}
