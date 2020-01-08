package Generics;

public class GenericMethods {

	public static <T extends Number> T array_max(T data[], int n) {
		T max = data[0];
		for (int i = 1; i < n; i++) {
			if (data[i].longValue() > max.longValue()) {
				max = data[i];
			}
		}
		return max;
	}

}
