package BasicTricky;

 class A2{
	 static void method() {
		System.out.println("Class A");
	}
	
}

final class B2 extends A2{
	final static void method() {
		System.out.println("Class B");
	}
}

public class InheritanceC {
     
	public static void main(String[] args) {
		A2 a = new B2();
		B2 b = new B2();
		
		a.method();
		b.method();
	}
}
