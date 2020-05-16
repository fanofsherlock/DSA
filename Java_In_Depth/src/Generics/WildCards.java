package Generics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public class WildCards {

	public static void main(String[] args) {
		/*
		 * List<?> wildcardList = new ArrayList<Object>(); List<Animal> list = new
		 * ArrayList<WildCards.Animal>(); ArrayList<Object> objects = new ArrayList<>();
		 * addDogs(objects);
		 */
		Set<Integer> set = new CopyOnWriteArraySet<Integer>();
		set.add(21);

		Queue<String> q = new LinkedList<String>();
		q.add("a");
		printCollections2(set);

	}

	public static void addDogs(List<? super Animal> list) {
		list.add(new Dog("tom"));
	}

	static class Animal {

	}

	static class Dog extends Animal {
		public Dog(String s) {
			// TODO Auto-generated constructor stub
		}
	}

	static void printCollections(Collection c) {
		Iterator i = c.iterator();
		while (i.hasNext()) {
			System.out.println(i.next().toString());
		}
	}

	static <T extends Number> void printCollections2(Collection<T> c) {
		Iterator i = c.iterator();
		while (i.hasNext()) {
			System.out.println(i.next().toString());
		}
	}

	// wildcard for everything
	static void printCollections3(Collection<? extends Number> c) {
		for (Object o : c) {

		}
		Iterator i = c.iterator();
		while (i.hasNext()) {
			System.out.println(i.next().toString());
		}
	}

}
