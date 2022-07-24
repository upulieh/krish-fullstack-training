package com.upulie.rentcloud.profileservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upulie.rentcloud.commons.model.Customer;
import com.upulie.rentcloud.commons.model.Vehicle;
import com.upulie.rentcloud.profileservice.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository customerRepository;
	
	@Override
	public Customer save(Customer customer) {
		return customerRepository.save(customer);
	}
	
	@Override
	public Customer fetchCustomerById(int id) {
		Optional<Customer> customer = customerRepository.findById(id); //Optional helps with not having to check for null 
		
		if(customer.isPresent()) {
			return customer.get();
		}
		return null; 
	}
	
	@Override
	public List<Customer> fetchAllCustomers(){
		Iterable<Customer> customers=customerRepository.findAll();
		
		List<Customer> list= new ArrayList<Customer>();
		
		customers.forEach(c -> {
			list.add(c);
		});

		return list; 
	}
}
