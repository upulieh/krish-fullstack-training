package com.upulie.rentcloud.profileservice.service;

import java.util.List;

import com.upulie.rentcloud.commons.model.Customer;

public interface CustomerService {
	Customer save(Customer customer);
	Customer fetchCustomerById(int id);
	List<Customer> fetchAllCustomers(); 
}
