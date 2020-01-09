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

	public static void main(String[] args) {

		int x = 2;
		switch (x) {
		case 1:
		case 2:
			break;
		case 3:
			System.out.println("First statement");
			break;
		case 4:
			System.out.println("Second statement");
		default:
			System.out.println("Default statement");
			break;
		}
	}

}
