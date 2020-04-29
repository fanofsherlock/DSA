package ParkingLotDesign;

public enum VehicleType {
	BIKES(10), CARS(20), TRUCKS(40);

	int minSpaceRequiredSquareFeet;

	private VehicleType(int minSpaceRequiredSquareFeet) {
		this.minSpaceRequiredSquareFeet = minSpaceRequiredSquareFeet;
	}

}
