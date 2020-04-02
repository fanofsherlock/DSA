package Strings;

public class Basic {

	static void basicObjectsEqualitycheck() {
		String one = "Hello";
		String two = "Hello";

		if (one == two) {
			System.out.println("one == two");
		} else {
			System.out.println("one != two");
		}
	}

	public static void main(String[] args) {
		basicObjectsEqualitycheck();
	}

}
