package com.upulie.rentcloud.vehicleservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.upulie.rentcloud.commons.model.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, Integer>{
	//the abstract methods are already provided in both JpaRepository and crudRepository
}
