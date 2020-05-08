package CCD;

public class CoffeeBuilder {
	CoffeeTypes coffee;

	public CoffeeBuilder chooseCoffeType(CoffeeTypes type) {
		coffee = type;
		return this;
	}

	public CoffeeBuilder addMilk() {
		if (ToppingsTypes.MILK.remainingQuantity > 0) {
			coffee.addTopping(ToppingsTypes.MILK);
			ToppingsTypes.MILK.useUpQuanity();
		} else {
			// throw exception
		}

		return this;

	}

	public CoffeeBuilder addChochalte() {
		if (ToppingsTypes.CHOCALATE_CHIPS.remainingQuantity > 0) {
			coffee.addTopping(ToppingsTypes.CHOCALATE_CHIPS);
			ToppingsTypes.CHOCALATE_CHIPS.useUpQuanity();
		} else {
			// throw exception
		}

		return this;
	}

	public CoffeeTypes build() {
		return coffee;
	}

}
