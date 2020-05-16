package Generics;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentSkipListMap;

public class CampStudies {

	public static void main(String[] args) {
		LinkedList<Integer> t = new LinkedList<Integer>();
		Shivam<Integer> s = new Shivam<Integer>(10);
		s.printName();
		Shivam<String> sInt = new Shivam<String>("");
		sInt.printName();
		sInt.changeItem("");
		sInt.printName();

		List<String> l = new ArrayList<String>();
		method(l);

	}

	// Access specifier, generic declaration, return type, method signature
	public static <K extends Number, V extends Number> void someGenMethod(K val) {

	}

	// final/static class <Enums>
	static class Shivam<E> {
		E name;

		public Shivam(E init) {
			this.name = init;
		}

		public void changeItem(E newName) {
			name = newName;
		}

		public void printName() {
			System.out.println(name.toString());
		}
	}

	static void method(List<? extends Object> l) {
		new ConcurrentSkipListMap<String, Integer>();
	}

}
