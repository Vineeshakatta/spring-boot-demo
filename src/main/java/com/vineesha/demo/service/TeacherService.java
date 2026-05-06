package com.vineesha.demo.service;

import java.util.List;

import com.vineesha.demo.entity.Teacher;

public interface TeacherService {
	
	List<Teacher> getAllTeachers();

	Teacher getTeacherById(Long id);

	Teacher createTeacher(Teacher teacher);

	Teacher updateTeacher(Long id, Teacher teacher);

	void deleteTeacher(Long id);
	
}
