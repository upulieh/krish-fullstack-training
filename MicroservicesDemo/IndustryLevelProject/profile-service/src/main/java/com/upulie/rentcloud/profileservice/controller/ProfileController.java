package com.upulie.rentcloud.profileservice.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.upulie.rentcloud.commons.model.Customer;
import com.upulie.rentcloud.profileservice.service.CustomerService;

@RestController
@RequestMapping(value = "/services")
public class ProfileController {
	
	@Autowired
	CustomerService customerService;
	
	//save a particular profile
	//POST, http://localhost:8191/services/profile (with JSON body of Customer parameters)
	@RequestMapping(value="/profile",method = RequestMethod.POST)
	public Customer save(@RequestBody Customer customer) {
		return customerService.save(customer);
	}
	
	//fetch a particular profile
	//GET, http://localhost:8191/services/profile?id=1
	@RequestMapping(value="/profile",method = RequestMethod.GET)
	public ResponseEntity<Customer> fetchCustomer(@RequestParam int id){
		Customer customer = customerService.fetchCustomerById(id);
		
		if(customer==null) {
			return ResponseEntity.notFound().build();
		}else {
			return ResponseEntity.ok().body(customer);
		}
	}
	
	//fetch all profiles
	//GET, http://localhost:8191/services/profiles
	@RequestMapping(value="/profiles",method = RequestMethod.GET)
	public ResponseEntity<List<Customer>> fetchAllCustomers(){
		List<Customer> customers = customerService.fetchAllCustomers();
		
		if(customers==null) {
			return ResponseEntity.notFound().build();
		}else {
			return ResponseEntity.ok().body(customers);
		}
	}
}
