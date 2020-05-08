package CCD;

import java.util.List;

public enum CoffeeTypes {
	HAZELNUT(0), MOCHA(0), AFRICAN(0), INDIAN(0);

	int remainingQuantity;
	List<ToppingsTypes> toppings;

	private CoffeeTypes(int remainingQuantity) {
		this.remainingQuantity = remainingQuantity;
	}

	void refill(int capacity) {
		remainingQuantity += capacity;
	}

	void addTopping(ToppingsTypes type) {
		toppings.add(type);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Coffee Type: " + name() + "\n" + "Toppings :");
		for (ToppingsTypes t : toppings) {
			sb.append(t.name() + " ");
		}

		return sb.toString();
	}
}
