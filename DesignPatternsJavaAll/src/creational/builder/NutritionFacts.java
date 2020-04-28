package creational.builder;

public class NutritionFacts {

	// Complex object with multiple property
	private final int servingSize;
	private final int servings;
	private final int calories;
	private final int fat;
	private final int sodium;
	private final int carbohydrate;

	// Private constructor which takes the builder object as input
	private NutritionFacts(NutritionFactsBuilder builder) {
		
		//Copying from 
		servingSize = builder.servingSize;
		servings = builder.servings;
		calories = builder.calories;
		fat = builder.fat;
		sodium = builder.sodium;
		carbohydrate = builder.carbohydrate;
	}

	public static class NutritionFactsBuilder {
		// Required parameters to be set in constructor
		private final int servingSize;
		private final int servings;

		// Optional parameters - initialized to default values
		//Later could be set through fluent APIs
		private int calories = 10;
		private int fat = 0;
		private int carbohydrate = 0;
		private int sodium = 0;

		public NutritionFactsBuilder(int servingSize, int servings) {
			this.servingSize = servingSize;
			this.servings = servings;
		}

		public NutritionFactsBuilder calories(int val) {
			calories = val;
			return this;
		}

		public NutritionFactsBuilder fat(int val) {
			fat = val;
			return this;
		}

		public NutritionFacts build() {
			return new NutritionFacts(this);
		}


		public NutritionFactsBuilder carbohydrate(int val) {
			carbohydrate = val;
			return this;
		}

		public NutritionFactsBuilder sodium(int val) {
			sodium = val;
			return this;
		}

	}

	
	
	
	
	public static void main(String[] args) {
		NutritionFacts nutri = new NutritionFacts.NutritionFactsBuilder(21, 21).calories(20).sodium(31).build();
	}
}