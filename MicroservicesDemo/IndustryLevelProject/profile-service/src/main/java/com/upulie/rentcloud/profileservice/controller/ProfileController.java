package com.upulie.rentcloud.profileservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
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

	// save a particular profile
	// POST, http://localhost:8191/services/customers (with JSON body of Customer
	// parameters)
	// enable permission_role level access to everyone who has 'create' capabilities
	@RequestMapping(value = "/customers", method = RequestMethod.POST)
	@PreAuthorize("hasAuthority('create_profile')")
	public Customer save(@RequestBody Customer customer) {
		return customerService.save(customer);
	}

	// fetch a particular profile
	// GET, http://localhost:8191/services/customers/{id}
	@RequestMapping(value="/customers/{id}",method = RequestMethod.GET)
	@PreAuthorize("hasAuthority('read_profile')") //everyone with 'read_profile' access 
	public ResponseEntity<Customer> fetch(@PathVariable(value="id") int customerid){
		Customer customer = customerService.fetchCustomerById(customerid);
		
		if(customer==null) {
			return ResponseEntity.notFound().build();
		}else {
			return ResponseEntity.ok().body(customer);
		}
	}

	// fetch all profiles
	// GET, http://localhost:8191/services/customers
	// enable role level access to everyone who has 'ROLE_operator' level
	// if you have multiple, you can say any
	@RequestMapping(value = "/customers", method = RequestMethod.GET)
	@PreAuthorize("hasAuthority('read_profile')") // everyone with 'read_profile' access
	public ResponseEntity<List<Customer>> fetch() {
		List<Customer> customers = customerService.fetchAllCustomers();

		if (customers == null) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok().body(customers);
		}
	}
}
