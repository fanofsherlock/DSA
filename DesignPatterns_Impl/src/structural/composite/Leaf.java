package structural.composite;

public class Leaf implements Component {
	int id;

	public Leaf(int id) {
		this.id = id;
	}

	@Override
	public void performWork(String task) {
		System.out.println(id + " " + task);
	}
}




