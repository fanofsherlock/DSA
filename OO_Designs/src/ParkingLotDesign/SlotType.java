package ParkingLotDesign;

public enum SlotType {
	SMALL(10), MEDIUM(20), BIG(40);

	int size;

	private SlotType(int size) {
		this.size = size;
	}
}
