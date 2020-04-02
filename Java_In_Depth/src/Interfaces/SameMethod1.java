package Interfaces;

public interface SameMethod1 {

	default void method(){
		System.out.println("Same Method 1 interface");
	}
	void sameMethod();
}
