package lambStreams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.stream.Collectors;

class TempStudent {
	public String name;
	public int age;
	public Address address;
	public List<MobileNumber> mobileNumbers;

	public TempStudent(String name, int age, Address address, List<MobileNumber> mobileNumbers) {
		this.name = name;
		this.age = age;
		this.address = address;
		this.mobileNumbers = mobileNumbers;
	}
}

public class Student implements Comparable<Student> {
	private String name;
	private int age;
	private Address address;
	private List<MobileNumber> mobileNumbers;

	public Student(String name, int age, Address address, List<MobileNumber> mobileNumbers) {
		this.name = name;
		this.age = age;
		this.address = address;
		this.mobileNumbers = mobileNumbers;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public Address getAddress() {
		return address;
	}

	public List<MobileNumber> getMobileNumbers() {
		return mobileNumbers;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public void setMobileNumbers(List<MobileNumber> mobileNumbers) {
		this.mobileNumbers = mobileNumbers;
	}

	@Override
	public String toString() {
		return "Student{" + "name='" + name + '\'' + ", age=" + age + ", address=" + address + ", mobileNumbers="
				+ mobileNumbers + '}';
	}

	@Override
	public int compareTo(Student o) {
		return this.getName().compareTo(o.getName());
	}

	public static void main(String[] args) {
		Student student1 = new Student("Jayesh", 20, new Address("1234"),
				Arrays.asList(new MobileNumber("1233"), new MobileNumber("1234")));

		Student student2 = new Student("Khyati", 20, new Address("1235"),
				Arrays.asList(new MobileNumber("1111"), new MobileNumber("3333"), new MobileNumber("1233")));

		Student student3 = new Student("Jason", 20, new Address("1236"),
				Arrays.asList(new MobileNumber("3333"), new MobileNumber("4444")));

		List<Student> students = Arrays.asList(student1, student2, student3);

		// Exact name match Jayesh
		students.parallelStream().filter(e -> e.getName().equals("Jayesh"))
				.forEach(e -> System.out.println(e.getName()));

		// Getting Student Objects from Temp Objects

		TempStudent tmpStud1 = new TempStudent("Jayesh1", 201, new Address("12341"),
				Arrays.asList(new MobileNumber("12331"), new MobileNumber("12341")));

		TempStudent tmpStud2 = new TempStudent("Khyati1", 202, new Address("12351"),
				Arrays.asList(new MobileNumber("11111"), new MobileNumber("33331"), new MobileNumber("12331")));

		List<TempStudent> tmpStudents = Arrays.asList(tmpStud1, tmpStud2);

		List<Student> newStudentList = tmpStudents.parallelStream()
				.map(t -> new Student(t.name, t.age, t.address, t.mobileNumbers)).collect(Collectors.toList());

		// List of student names
		students.parallelStream().map(e -> e.getName()).collect(Collectors.toList());

		// List of students into a string
		String s = students.parallelStream().map(e -> e.getName()).collect(Collectors.joining(",", "[", "]"));
		System.out.println(s);

		// Grouping the students based on alphabets of thie first name and their sorting
		// them further
		Map<Character, TreeSet<Student>> sMap = students.parallelStream()
				.collect(Collectors.groupingBy(e -> e.getName().charAt(0), Collectors.toCollection(TreeSet::new)));

		for (Map.Entry<Character, TreeSet<Student>> m : sMap.entrySet()) {
			System.out.print("\n[");
			for (Student st : m.getValue()) {
				System.out.print(st.getName() + ",");
			}
			System.out.print("]");
		}

		// Grouping and counting
		Map<Character, Long> sMap2 = students.parallelStream()
				.collect(Collectors.groupingBy(e -> e.getName().charAt(0), Collectors.counting()));

		for (Map.Entry<Character, Long> m : sMap2.entrySet()) {
			System.out.print("\n[");
			System.out.print(m.getKey() + ": " + m.getValue());
			System.out.print("]");
		}

		// Grouping and filtering
		Map<Character, List<Student>> sMap3 = students.parallelStream()
				.collect(Collectors.groupingBy(e -> e.getName().charAt(0),
						Collectors.filtering(e -> e.getName().charAt(0) == 'J', Collectors.toList())));

		// Grouping and calculating average per group
		Map<Character, Double> sMap4 = students.parallelStream().collect(Collectors
				.groupingBy(e -> e.getName().charAt(0), Collectors.averagingInt(Student::returnNameNumericCount)));

		for (Map.Entry<Character, Long> m : sMap2.entrySet()) {
			System.out.print("\n[");
			System.out.print(m.getKey() + ": " + m.getValue());
			System.out.print("]");
		}
		
		

	}

	public static int returnNameNumericCount(Student s) {
		return Character.getNumericValue(s.getName().charAt(0));
	}

}

class Address {
	private String zipcode;

	public Address(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
}

class MobileNumber {
	private String number;

	public MobileNumber(String number) {
		this.number = number;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

}