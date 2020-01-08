package Interfaces;;

public class SameMethodImpl implements SameMethod1, SameMethod2{

	@Override
	public void sameMethod() {
		System.out.println("This is same method fucks");
	}

	@Override
	public void method() {
		SameMethod2.super.method();
		SameMethod1.super.method();
	}
	

	
}
