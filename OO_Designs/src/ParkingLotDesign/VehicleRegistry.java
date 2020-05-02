package ParkingLotDesign;

import java.time.LocalDateTime;
import java.util.HashMap;

public class VehicleRegistry {
	private HashMap<Vehicle, LocalDateTime> map;

	public VehicleRegistry() {
		map = new HashMap<Vehicle, LocalDateTime>();
	}

	public void registerVehicle(Vehicle v) {
		map.computeIfAbsent(v, key -> LocalDateTime.now());
	}

	public LocalDateTime deRegisterVehicle(Vehicle v) {
		LocalDateTime result = map.get(v);
		map.remove(v);
		return result;
	}

	
	
	

}
