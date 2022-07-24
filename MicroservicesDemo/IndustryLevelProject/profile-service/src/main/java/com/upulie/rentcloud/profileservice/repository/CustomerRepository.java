package com.upulie.rentcloud.profileservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.upulie.rentcloud.commons.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{
	//the abstract methods are already provided in both JpaRepository and crudRepository
}
