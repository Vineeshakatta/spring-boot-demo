package com.vineesha.demo.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.vineesha.demo.entity.Teacher;
import com.vineesha.demo.repository.TeacherRepository;
import com.vineesha.demo.service.TeacherService;

@Service
public class TeacherServiceImpl implements TeacherService {

	private final Logger logger = LoggerFactory.getLogger(TeacherServiceImpl.class);

	private final TeacherRepository teacherRepo;

	public TeacherServiceImpl(TeacherRepository teacherRepo) {
		this.teacherRepo = teacherRepo;
	}
	
	@Override
	public List<Teacher> getAllTeachers() {
		return teacherRepo.findAll();
	}

	@Override
	public Teacher getTeacherById(Long id) {
		return teacherRepo.findById(id)
				.orElseThrow(() -> new RuntimeException("Teacher doesn't exists with {id}"));
	}

	@Override
	public Teacher createTeacher(Teacher teacher) {
		return teacherRepo.save(teacher);
	}

	@Override
	public Teacher updateTeacher(Long id, Teacher teacher) {
		Teacher existing = getTeacherById(id);
		existing.setName(teacher.getName());
		return teacherRepo.save(existing);
	}

	@Override
	public void deleteTeacher(Long id) {
		teacherRepo.deleteById(id);
	}

}
