package com.krishantha.training.salesmanager.service;

import java.util.List;

import com.krishantha.training.salesmanager.model.Employee;
import com.krishantha.training.salesmanager.repository.EmployeeRepository;
import com.krishantha.training.salesmanager.repository.HibernateEmployeeRepositoryImpl;

public class EmployeeServiceImpl implements EmployeeService{
	
	EmployeeRepository employeeRepository = new HibernateEmployeeRepositoryImpl();
	
	@Override
	public List<Employee> getAllEmployees(){
		return employeeRepository.getAllEmployees();
	}
}
