package com.upulie.rentcloud.vehicleservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upulie.rentcloud.commons.model.Customer;
import com.upulie.rentcloud.commons.model.Vehicle;
import com.upulie.rentcloud.vehicleservice.repository.VehicleRepository;

@Service
public class VehicleServiceImpl implements VehicleService {

	@Autowired
	VehicleRepository vehicleRepository;

	@Override
	public Vehicle save(Vehicle vehicle) {
		return vehicleRepository.save(vehicle);
	}

	@Override
	public Vehicle fetchById(int id) {
		Optional<Vehicle> vehicle = vehicleRepository.findById(id);

		if (vehicle.isPresent()) {
			return vehicle.get();
		}
		return null;

	}
	
	@Override
	public List<Vehicle> fetchAllVehicles(){
		Iterable<Vehicle> vehicles=vehicleRepository.findAll();
		
		List<Vehicle> list= new ArrayList<Vehicle>();
		
		vehicles.forEach(c -> {
			list.add(c);
		});

		return list; 
	}
}
