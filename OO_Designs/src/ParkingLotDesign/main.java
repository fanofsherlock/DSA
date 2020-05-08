package ParkingLotDesign;

public class main {

	public main() {
		ParkingLotControlSystem system = ParkingLotControlSystem.getInstance();
		system.enterVehicle("AAA", VehicleType.BIKES);
		system.enterVehicle("AAA", VehicleType.BIKES);
		system.enterVehicle("AAA", VehicleType.BIKES);
		system.enterVehicle("AAA", VehicleType.BIKES);
		system.enterVehicle("AAA", VehicleType.BIKES);
		system.enterVehicle("AAA", VehicleType.BIKES);
		system.enterVehicle("AAA", VehicleType.BIKES);

		system.enterVehicle("AAA", VehicleType.CARS);
		system.enterVehicle("AAA", VehicleType.CARS);
		system.enterVehicle("AAA", VehicleType.CARS);
		system.enterVehicle("AAA", VehicleType.CARS);

		system.enterVehicle("AAA", VehicleType.TRUCKS);
		system.enterVehicle("AAA", VehicleType.TRUCKS);
		system.enterVehicle("AAA", VehicleType.TRUCKS);
		system.enterVehicle("AAA", VehicleType.TRUCKS);

	}

}
