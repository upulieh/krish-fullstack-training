package mypackage;

import java.util.HashMap;
import java.util.Map;

public class Registry {
	//create the objects of what you initially created
	//uses new keyword 
	private Map<VehicleType, Vehicle> vehicles = new HashMap<VehicleType, Vehicle>();

	public Registry() {
		this.initialize();
	}
	
	//returning the vehicle which is stored in the hashmap
	public Vehicle getVehicle(VehicleType vehicleType) {
		
		
		//casting is needed as clone will always return Object type
		Vehicle vehicle=null;
		try {
			vehicle = (Vehicle) vehicles.get(vehicleType).clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return vehicle;
	}
	
	private void initialize() {
		// initializing the vehicles registry 
		Car car=new Car();
		car.setType("Mini");
		car.setEngineCapacity(2000);
		car.setFuelType("Gasoline");
		
		Bus bus=new Bus();
		bus.setEngineCapacity(3000);
		bus.setNumberOfSeats(32);
		bus.setFuelType("Diesel");
		
		vehicles.put(VehicleType.CAR,car);
		vehicles.put(VehicleType.BUS,bus);
		
	}
	
}
