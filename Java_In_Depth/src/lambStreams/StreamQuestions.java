package lambStreams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Predicate;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.Stream.Builder;

/*
https://www.geeksforgeeks.org/collectors-tomap-method-in-java-with-examples/

Input: 
List<Employee> -> 1 million  

Streams:
1) In-demand data structure
2) Not a DS, it is a computation on ds

3) Intermediate operations
4) Terminal 


-> List<Employee>, HR dept

*/

public class StreamQuestions {

	static class Employee {
		String name;
		int EmpId;
		int salary;
		String dept;

		public Employee(String name, int empId, int salary, String dept) {
			super();
			this.name = name;
			EmpId = empId;
			this.salary = salary;
			this.dept = dept;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getEmpId() {
			return EmpId;
		}

		public void setEmpId(int empId) {
			EmpId = empId;
		}

		public int getSalary() {
			return salary;
		}

		public void setSalary(int salary) {
			this.salary = salary;
		}

		public String getDept() {
			return dept;
		}

		public void setDept(String dept) {
			this.dept = dept;
		}

		@Override
		public String toString() {
			return this.getName();
		}

	}

	public static void print(Object o) {
		System.out.println(o.toString());
	}

	public static void main(String[] args) {
		// QuestionSet1();
		QuesitonSet2();
		QuestionSet3();
		QuestionSet4();
		Question5();
	}

	// remove first and last digit of maximum number in a list
	private static void Question5() {
		
		List<Integer> list = new ArrayList<Integer>();
		list.add(11);
		list.add(22);
		list.add(33);
		list.add(44);
		list.add(555);
		int max = list.stream().mapToInt(e -> e).max().getAsInt();
		String strMax = String.valueOf(max);
		int num = 0;

		try {
			num = Integer.valueOf(strMax.substring(1, strMax.length() - 1));
		} catch (NumberFormatException e) {
			num = 0;
		}

		System.out.println(num);

	}

	// Sorting a map based on its value
	private static void QuestionSet4() {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("d", 7);
		map.put("e", 6);
		map.put("f", 5);
		map.put("a", 10);
		map.put("b", 9);
		map.put("c", 8);

		map.entrySet().stream().sorted((a, b) -> a.getValue() - b.getValue())
				.forEach(e -> System.out.println("key : " + e.getKey() + " Value : " + e.getValue()));

	}

	private static void QuestionSet3() {
		String str = "This is just a random story that I am writing in order for me to test "
				+ " some code and youo know that is a wonder opportunity to do so . It is awesome";

		Arrays.stream(str.split(" "));

		Predicate<String> Apred = e -> e.startsWith("a") || e.startsWith("A");
		Predicate<String> Epred = e -> e.startsWith("e") || e.startsWith("E");
		Predicate<String> Ipred = e -> e.startsWith("i") || e.startsWith("I");
		Predicate<String> Opred = e -> e.startsWith("o") || e.startsWith("O");
		Predicate<String> Upred = e -> e.startsWith("u") || e.startsWith("U");
		Predicate<String> allVowels = Apred.or(Epred).or(Ipred).or(Opred).or(Upred);

		Pattern pattern = Pattern.compile(" ");
		pattern.splitAsStream(str).filter(allVowels).collect(Collectors.toList()).forEach(e -> System.out.println(e));

	}

	public static void QuestionSet1() {
		List<Employee> list = new ArrayList<Employee>();
		list.add(new Employee("Aparna", 1, 30000, "HR"));
		list.add(new Employee("Babua", 2, 30000, "IT"));
		list.add(new Employee("Celina", 3, 40000, "ACCOUNTS"));
		list.add(new Employee("Dion", 4, 40000, "HR"));
		list.add(new Employee("Ezekiel", 5, 60000, "IT"));

		// Maximum and Average
		print(findMaxSalary(list));
		print(findAvgSalary(list));

		// Map and Filter
		print(findCountOfEmpWithnameStartingFrom(list, "A"));

		// ["HR" -> "1,2,3"]
		// ToMap (Notice how instead of using groupBy I am using toMap)
		groupDeptWithIds(list).forEach((k, v) -> System.out.println(k + " " + v));

		// Grouping By
		print(groupEmployeesByDept(list));

		// Grouping By and Aggregate Functions
		print(AverageSalaryByDept(list));

		// Partitioning by
		print(groupEmployeesAsITandNonIt(list));

		// Joining By (only works with String/Character streams)
		print(returnNameOfAllEmployeesBeforeC(list));
	}

	private static Map<String, Double> AverageSalaryByDept(List<Employee> list) {
		return list.parallelStream().collect(
				Collectors.groupingBy((Employee e) -> e.getDept(), Collectors.averagingInt(e -> e.getSalary())));
	}

	public static void QuesitonSet2() {

		Stream<Integer> stream1 = Stream.of(1, 2, 3);
		Stream<Integer> stream2 = Stream.iterate(0, i -> i + 1).limit(20);

		// StreamBuilder
		Builder<Employee> builder = Stream.builder();
		builder.accept(new Employee("test1", 1, 100, "IT"));
		builder.accept(new Employee("test2", 2, 200, "IT"));
		Stream<Employee> stream = builder.build();
	}

	// e.starsWith("A")||e.startsWith("B)
	private static String returnNameOfAllEmployeesBeforeC(List<Employee> list) {
		return list.parallelStream().map(e -> e.getName()).takeWhile(e -> !e.startsWith("Z"))
				.collect(Collectors.joining(",", "[", "]"));
	}

	private static Map<Boolean, List<Employee>> groupEmployeesAsITandNonIt(List<Employee> list) {
		return list.parallelStream().collect(Collectors.partitioningBy((Employee e) -> e.getDept().equals("IT")));
	}

	private static Map<String, List<Employee>> groupEmployeesByDept(List<Employee> list) {
		return list.parallelStream().collect(Collectors.groupingBy((Employee e) -> e.getDept()));
	}

	private static Map<String, String> groupDeptWithIds(List<Employee> list) {
		return list.parallelStream().collect(
				Collectors.toMap(e -> e.getDept(), e -> e.getEmpId() + "", (key1, key2) -> key1 + ", " + key2));
	}

	private static Map<String, String> mapDeptWithIdsAscending(List<Employee> list) {
		return list.parallelStream().collect(Collectors.toMap((Employee e) -> e.getDept(),
				(Employee e) -> e.getEmpId() + "", (val1, val2) -> val1 + ", " + val2));
	}

	private static long findCountOfEmpWithnameStartingFrom(List<Employee> list, String string) {
		return list.parallelStream().filter(e -> e.getName().startsWith(string)).count();
	}

	private static double findAvgSalary(List<Employee> list) {
		return list.parallelStream().mapToInt(e -> e.getSalary()).average().getAsDouble();
	}

	private static int findMaxSalary(List<Employee> list) {
		return list.parallelStream().mapToInt(e -> e.getSalary()).max().getAsInt();
	}

}
