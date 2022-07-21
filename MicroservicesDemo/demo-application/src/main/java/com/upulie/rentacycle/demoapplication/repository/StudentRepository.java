package com.upulie.rentacycle.demoapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.upulie.rentacycle.demoapplication.model.Student;

public interface StudentRepository extends JpaRepository<Student,Integer> {
	
//	Student save(Student student); //no need to use this since we are using JpaRepository
	
}
