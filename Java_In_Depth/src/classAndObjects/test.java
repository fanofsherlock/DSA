package classAndObjects;

public class test {
	private int test;

	public test() {
		System.out.println("Default");
	}

	test(int test) {
		this();
		this.test = test;
	}

	void method1() {
	}

	public static void main(String[] args) {
		test t = new test();
	}

}
