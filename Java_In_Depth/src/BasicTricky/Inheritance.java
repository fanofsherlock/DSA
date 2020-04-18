package BasicTricky;

class A {
	String s = "Class A";
}

class B extends A {
	String s = "Class B";

	{
		System.out.println(super.s);
	}
}

class C extends B {
	String s = "Class C";

	{
		System.out.println(super.s);
	}
}

class Z {
	int[] a = new int[5];

	{
		a[0] = 10;
	}
}

 class MainClass extends Z {
	{
		a = new int[5];
	}

	{
		System.out.println(a[0]);
	}

}

public class Inheritance {
	public static void main(String[] args) {
		//TestInheritanceConstructorsHierachy();
		TestInheritanceValueInitialization();

	}

	private static void TestInheritanceConstructorsHierachy() {
		C c = new C();
		System.out.println(c.s);

	}

	private static void TestInheritanceValueInitialization() {
		MainClass main = new MainClass();
	}

	
}
