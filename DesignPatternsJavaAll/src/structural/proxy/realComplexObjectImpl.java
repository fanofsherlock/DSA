package structural.proxy;

public class realComplexObjectImpl implements complexExpensiveObject {

	@Override
	public void expensive1(String s) {
		System.out.println("Real Expensive 1");
	}

	public void expensive2(String s) {
		System.out.println("Real Expensive 1");
	};

	@Override
	public void expensive3(String s) {
		System.out.println("Real Expensive 1");
	}
}
