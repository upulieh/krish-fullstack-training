package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	StudentRepository studentRepository;
	
	@Override
	public Student save(Student student) {
		//comes from the controller, to the service, goes to the repository
		return studentRepository.save(student);
	}
	
	//using optional omits the need to check for null 
	//data retrieving a null, is handled in the service layer
	public Student fetchStudentById(int id) {
		Optional<Student> student = studentRepository.findById(id);
		
		if(student.isPresent()) {
			return student.get();
		}
		return null;
	}
}
