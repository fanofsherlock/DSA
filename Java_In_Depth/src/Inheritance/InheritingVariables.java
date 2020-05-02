package Inheritance;

class A1 {
	public int i;
	protected int j;
}

class B1 extends A1 {
	int j;

	void display() {
		super.i = 10;
		super.j = 3;
		System.out.println(i+" "+j);
	}
}

public class InheritingVariables {
	public static void main(String[] args) {
		B1 obj = new B1();
		obj.i=1;
		obj.j=2;
		obj.display();
				
	}
	
}
