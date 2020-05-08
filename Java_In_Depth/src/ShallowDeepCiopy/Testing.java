package ShallowDeepCiopy;

import java.util.ArrayList;

public class Testing {
	static class Employee {
		public String name;

		public Employee(String name) {
			this.name = name;
		}

		public String getName() {
			return name;
		}
		
		public void setName(String name) {
			this.name = name;
		}

	}

	public static void main(String[] args) {
		// testingCloneOperation();
		testingArratListCopyOperation();
	}

	private static void testingArratListCopyOperation() {
		Employee e1 = new Employee("A");
		Employee e2 = new Employee("B");
		ArrayList<Employee> list = new ArrayList<Testing.Employee>();
		list.add(e1);
		list.add(e2);
		ArrayList<Employee> list2 = (ArrayList<Employee>) list.clone();
		System.out.println(list2.size());
		list2.get(0).setName("Changed");
		System.out.println(list.get(0).name);

	}

	private static void testingCloneOperation() {
		Employee e1 = new Employee("A");
		Employee e2 = new Employee("B");

		Employee[] og = new Employee[] { e1, e2 };
		Employee[] clone = og.clone();

		// Checking if memory location is same or not
		for (int i = 0; i < og.length; i++) {
			if (og[i] == clone[i]) {
				System.out.println(true);
			}
		}

		// Can I modify orignal array object using clone
		clone[0].name = "A1";
		System.out.println(og[0].name);

	}

}
