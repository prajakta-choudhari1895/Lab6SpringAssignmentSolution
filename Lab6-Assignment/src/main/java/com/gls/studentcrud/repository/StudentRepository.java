package com.gls.studentcrud.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gls.studentcrud.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
	

}
