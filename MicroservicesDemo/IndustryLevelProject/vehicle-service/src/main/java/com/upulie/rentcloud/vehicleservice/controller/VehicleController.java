package com.upulie.rentcloud.vehicleservice.controller;

import java.util.List;

import javax.annotation.security.PermitAll;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.upulie.rentcloud.commons.model.Vehicle;
import com.upulie.rentcloud.vehicleservice.service.VehicleService;

@RestController
@RequestMapping(value = "/services")
public class VehicleController {

	@Autowired
	VehicleService vehicleService;

	// save a particular vehicle
	// POST, http://localhost:8192/services/vehicle (with JSON body of Vehicle
	// parameters)
	@RequestMapping(value = "/vehicle", method = RequestMethod.POST)
//	similar to @PreAuthorize("hasRole('create_profile')")  
	@PreAuthorize("hasAnyRole('ROLE_admin')")
	public Vehicle save(@RequestBody Vehicle vehicle) {
		return vehicleService.save(vehicle);
	}

	// fetch a particular vehicle
	// GET, http://localhost:8192/services/vehicle?id=1
	@RequestMapping(value = "/vehicle", method = RequestMethod.GET)
//	similar to @PreAuthorize("hasAuthority('read_profile')")  
	@PreAuthorize("hasAnyRole('ROLE_admin','ROLE_editor','ROLE_operator')")
	public ResponseEntity<Vehicle> fetchVehicle(@RequestParam int id) {
		Vehicle vehicle = vehicleService.fetchById(id);
		if (vehicle == null) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok().body(vehicle);
		}
	}

	// fetch all profiles
	// GET, http://localhost:8192/services/vehicles
	@RequestMapping(value = "/vehicles", method = RequestMethod.GET)
//	similar to @PreAuthorize("hasAuthority('read_profile')")  
	@PreAuthorize("hasAnyRole('ROLE_admin','ROLE_editor','ROLE_operator')")
	public ResponseEntity<List<Vehicle>> fetchAllVehicles() {
		List<Vehicle> vehicles = vehicleService.fetchAllVehicles();

		if (vehicles == null) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok().body(vehicles);
		}
	}

}
