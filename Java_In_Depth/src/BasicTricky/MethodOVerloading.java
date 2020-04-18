package BasicTricky;

public class MethodOVerloading {

	public static void printObj(Object o) {
		System.out.println("Object Method :" + o.toString());
	}

	public static void printObj(String s) {
		System.out.println("String Method :" + s);
	}

	private static void printObj(double[] d) {
		System.out.println("double array");
	}

	public static void main(String[] args) {
		printObj("Object");
	}

}
