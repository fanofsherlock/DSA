package structural.composite;

public class CompositeTest {

	public static void main(String[] args) {
		Composite comp1 = new Composite();
		comp1.registerComponent(new Leaf(1));
		comp1.registerComponent(new Leaf(2));

		Composite comp2 = new Composite();
		comp2.registerComponent(new Leaf(4));
		comp2.registerComponent(new Leaf(5));
		

		Composite comp3 = new Composite();
		comp3.registerComponent(comp1);
		comp3.registerComponent(comp2);

		comp3.performWork("Work");

	}
	
	

}
