package CCD;

import java.util.List;

public enum ToppingsTypes {

	MILK(0), CHOCALATE_CHIPS(0), MARSHMELLOW(0);

	int remainingQuantity;
	List<ToppingsTypes> toppings;

	private ToppingsTypes(int remainingQuantity) {
		this.remainingQuantity = remainingQuantity;
	}

	public void useUpQuanity() {
		remainingQuantity--;
	}

	void refill(int capacity) {
		remainingQuantity += capacity;
	}

	@Override
	public String toString() {
		return name();
	}

}
