package Lists;

public class Test {

	public static void main(String[] args) {
		ArrayListTest();
	}

	private static void ArrayListTest() {

		
		MyArrayList a = new MyArrayList(3);
		a.add(1);
		a.add(2);
		a.add(3);

		System.out.println(a);

		a.remove(3);
		a.remove(1);
		a.remove(5);

		System.out.println(a);

		a.add(10);
		a.add(11);

		System.out.println(a);
	}

}
