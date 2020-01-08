package AccessModifiers;

//can't be private or protected
class Animal {
	protected String s;
}

//multiple classes can be default in one Java file
class Vehicle {
}

//only one class can be public
public class ProtectedTest {
	public static void main(String[] args) {

	}

	private class Fruit {
		public String name = "Sue";
	}

	private class Apple extends Fruit {

	}
}
