package com.gls.studentcrud.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gls.studentcrud.entity.Student;


public interface StudentService {
	
	public List<Student> findAll();

	public Student findById(int id);

	public void save(Student student);

	public void deleteById(int id);



}
