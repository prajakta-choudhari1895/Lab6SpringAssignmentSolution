package com.gls.studentcrud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.gls.studentcrud.entity.Student;
import com.gls.studentcrud.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	StudentRepository studentRepository;

	@Override
	public List<Student> findAll() {
		List<Student> students = studentRepository.findAll();
		return students;
	}

	@Override
	public Student findById(int id) {
		Student student = studentRepository.findById(id).get();
		return student;
	}

	@Override
	public void save(Student student) {
		studentRepository.save(student);
		
	}

	@Override
	public void deleteById(int id) {
		studentRepository.deleteById(id);
		
	}


}
