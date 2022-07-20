package com.upulie.rentacycle.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
	
	@RequestMapping(value="/rent",method = RequestMethod.GET)
	public String greeting1() {
		return "Rent A Cycle";
	}
	@RequestMapping(value="/rent",method = RequestMethod.POST)
	public String greeting2() {
		return "Rent A Cycle";
	}
	
}
