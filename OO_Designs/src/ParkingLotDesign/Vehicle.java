package ParkingLotDesign;

import java.util.Objects;

public class Vehicle {

	int id;
	final String licenseNumber;
	final VehicleType type;

	public Vehicle(int id, String licenseNumber, VehicleType type) {
		super();
		this.id = id;
		this.licenseNumber = licenseNumber;
		this.type = type;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLicenseNumber() {
		return licenseNumber;
	}

	public VehicleType getType() {
		return type;
	}

	@Override
	public boolean equals(Object obj) {

		// 1) if current object reference and provided reference are pointing to same underneath object
		if (obj == this) {
			return true;
		}

		// 2) Comparison with null should return false
		// 3) Not using instaceeOf(since it returns true for child classes also)
		if (obj == null || (obj.getClass() != this.getClass())) {
			return false;
		}

		Vehicle v = (Vehicle) obj;
		
		return Objects.deepEquals(this.getLicenseNumber(), v.getLicenseNumber())
				&& Objects.deepEquals(this.getType(), v.getType());
	}
	
	

	@Override
	public int hashCode() {
		return licenseNumber.hashCode() + this.getType().hashCode();
	}

}
