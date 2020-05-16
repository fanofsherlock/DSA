package AccessModifiers;

//can't be private or protected
class Animal {
	protected String s;
}

//multiple classes can be public in one java file
//but this class is accessible to all classes in the package
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
