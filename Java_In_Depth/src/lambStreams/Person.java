package lambStreams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringJoiner;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Person {

	static ArrayList<Person> list = new ArrayList<Person>();;

	String name;
	int salary;
	String gender;
	int band;

	public Person(String name, int salary, String gender, int age) {
		this.name = name;
		this.salary = salary;
		this.gender = gender;
		this.band = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return band;
	}

	public Person setAge(int age) {
		this.band = age;
		return this;
	}

	public static void main(String[] args) {

		list.add(new Person("A", 100, "M", 10));
		list.add(new Person("B", 200, "M", 20));
		list.add(new Person("C", 300, "F", 30));

		System.out.println(returnHighestSalary(list));
		System.out.println(returnHighestAge(list));
		System.out.println(returnEmployeesWithSameBand(20));
		System.out.println(groupEmployeesByBandList());
		System.out.println(partitionEmployeesBasedOnEligibility());

		
		//converting a List into a map that preserves original order of elements in the list
		list.parallelStream().collect(Collectors.toMap(Person::getName, Function.identity(),
				(e1, e2) -> e1.setAge(e1.getAge() + e2.getAge()), LinkedHashMap::new));
		
		Stream.of("a","bb","ccc","dddd").sorted((s1,s2)->s2.length()-s1.length()).forEach(System.out::println);;
	
		

	}

	private static Map<Boolean, List<Person>> partitionEmployeesBasedOnEligibility() {
		return list.parallelStream().collect(Collectors.partitioningBy(p -> p.salary > 1000));
	}

	private static Map<Integer, List<Person>> groupEmployeesByBandList() {
		return list.parallelStream().collect(Collectors.groupingBy(Person::getAge, Collectors.toList()));
	}

	private static Map<Integer, Set<Person>> groupEmployeesByBandSet() {
		return list.parallelStream().collect(Collectors.groupingBy(Person::getAge, Collectors.toSet()));
	}

	private static long returnEmployeesWithSameBand(int i) {
		return list.parallelStream().filter(e -> e.getAge() == i).count();
	}

	private static int returnHighestSalary(ArrayList<Person> list) {
		return list.stream().max(Comparator.comparing(Person::getSalary)).get().getSalary();

	}

	private static int returnHighestAge(ArrayList<Person> list) {
		return list.stream().max(Comparator.comparing(Person::getAge)).get().getAge();
	}

}
