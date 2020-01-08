package Lists;

public class ArrList {
	private final int sizeFactor = 5;
	private Object[] data;
	private int lastFilledIndex = -1;

	public ArrList(int capacity) {
		data = new Object[capacity];
	}

	public void add(int a) {
		if (lastFilledIndex > data.length - 1) {
			increaseSize();
		}
		data[++lastFilledIndex] = a;
	}

	private void increaseSize() {
		int size = data.length + sizeFactor;
		Object[] newData = new Object[size];

		for (int i = 0; i < data.length; i++) {
			newData[i] = data[i];
		}

		lastFilledIndex = data.length - 1;
		data = newData;
	}

	private void remove(int a) {
		int index = -1;
		for (int i = 0; i <= lastFilledIndex; i++) {
			if (data[i] == Integer.valueOf(a)) {
				index = i;
				break;
			}
		}

		if (index == -1) {
			System.out.println("Object not found");
			return;
		}

		for (int i = index; i < lastFilledIndex; i++) {
			data[i] = data[i + 1];
		}

		lastFilledIndex--;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i <= lastFilledIndex; i++) {
			sb.append(data[i].toString()+" ");
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		ArrList a = new ArrList(3);
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
