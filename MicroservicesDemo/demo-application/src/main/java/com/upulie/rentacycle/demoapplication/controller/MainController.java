package com.upulie.rentacycle.demoapplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.upulie.rentacycle.demoapplication.model.Student;
import com.upulie.rentacycle.demoapplication.service.StudentService;

@RestController
public class MainController {
	
	@Autowired
	StudentService studentService;
	
	@RequestMapping(value="/rent",method = RequestMethod.GET)
	public String greeting1() {
		return "Rent A Cycle";
	}
	@RequestMapping(value="/rent",method = RequestMethod.POST)
	public String greeting2() {
		return "Rent A Cycle";
	}
	
	@RequestMapping(value="/student",method=RequestMethod.POST)
	public Student save(@RequestBody Student student) {
		//comes from the request, to the controller, goes to the service 
		//also, sends back the saved student object
		return studentService.save(student);
	}
	
	
	
}
