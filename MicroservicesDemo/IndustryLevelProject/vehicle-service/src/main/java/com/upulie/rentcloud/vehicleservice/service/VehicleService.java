package com.upulie.rentcloud.vehicleservice.service;


import java.util.List;

import com.upulie.rentcloud.commons.model.Vehicle;

public interface VehicleService {
	Vehicle save(Vehicle vehicle);
	Vehicle fetchById(int id);
	List<Vehicle> fetchAllVehicles();
}
