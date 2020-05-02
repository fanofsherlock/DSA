package PassByValue;

class Men {
	public int number;
}

public class BasicPassByValue {
	public void doIt(int x, Men m) {
		x = 5;
		m.number = 10;
	}

	public static void main(String[] args) {
		BasicPassByValue obj = new BasicPassByValue();
		int x = 0;
		Men m = new Men();
		obj.doIt(x, m);
		System.out.println(x + " " + m.number);
	}

}
