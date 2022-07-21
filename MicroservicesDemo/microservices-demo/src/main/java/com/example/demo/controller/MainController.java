package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;

@RestController
public class MainController {
	
	@Autowired
	StudentService studentService;
	
	@RequestMapping(value="/rent",method = RequestMethod.GET)
	public String greeting1() {
		return "Rent A Cycle";
	}
	
	@RequestMapping(value="/student",method=RequestMethod.POST)
	public Student save(@RequestBody Student student) {
		//comes from the request, to the controller, goes to the service 
		//also, sends back the saved student object
		return studentService.save(student);
	}
	
	@RequestMapping(value="/student",method=RequestMethod.GET)
	public ResponseEntity<Student> fetchStudent(@RequestParam int id) {
		
		Student student= studentService.fetchStudentById(id);
		
		if(student==null) {
			return ResponseEntity.notFound().build();
		}else {
			return ResponseEntity.ok().body(student);
		}
		
	}
	
	
}
