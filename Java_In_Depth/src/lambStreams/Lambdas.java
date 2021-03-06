package lambStreams;

import java.util.ArrayList;
import java.util.Optional;
import java.util.function.*;
import java.util.stream.Stream;

public class Lambdas {

	interface Operator {
		public int operate(int i, int j);
	}

	interface Operator2 {
		public void print();
	}

	// PREDICATES - Takes one or more input and returns a boolean type
	// test(T t)
	private static Predicate<String> emptyString = (x) -> !x.equalsIgnoreCase("");
	private static BiPredicate<String, Integer> numCharacters = (x, y) -> x.length() == y;
	private static DoublePredicate dubPred = (x) -> x < 1000.234;
	private static IntPredicate intPred = (x) -> x < 100;
	private static Predicate<Integer> IntegerPred = (x) -> x < 100;
	private static LongPredicate longPred = (z) -> z < 1000000;

	// CONSUMER Interface. Takes one or more values and returns nothing;
	// void accept(T t)
	private static Consumer<String> printString = (x) -> System.out.println(x);
	private static BiConsumer<String, Integer> printStatement = (x, y) -> System.out
			.println(x + " has y number of char:? " + (x.length() == y));;

	// SUPPLIER which returns one or more values but consumes nothing
	// T get()
	private static Supplier<String> champion = () -> "champion";
	private static IntSupplier numChampions = () -> 24;
	private static DoubleSupplier champAvg = () -> 53.72;
	private static LongSupplier champSalary = () -> 2300000;

	private static Function<String, Stream<Integer>> function = (x) -> Stream.of(x.length());
	private static BiFunction<String, Integer, Double> someShit = (x, y) -> y.doubleValue() + 1000;
	private static DoubleToIntFunction justsomeMoreFunction = (x) -> 34;

	// UNARY OPERTOR Input and output are same in number and type
	private static UnaryOperator<String> unOp = (z) -> z;

	// BINARY OPERATOR(Two inputs of same type)
	private static BinaryOperator<String> conCat = (x, y) -> x + y;

	
	public static void main(String[] args) {

		// Integer Stream
		Stream<Integer> intStream1 = Stream.of(2, 3, 4, 353365);
		Optional<String> opt = intStream1.map(a -> "" + a).limit(20).findFirst();
		// System.out.println(opt.get());

		ArrayList<String> arr = SampleList();
		Stream<String> st2 = arr.stream().distinct().filter(e -> (Integer.valueOf(e).intValue()) < 100).skip(20);
		printCertainElements(st2);
		int[] a = new int[] { 1, 2 };
		System.out.println(a instanceof Object);

		int k = 400;
		Operator op = (i, j) -> i + j;

		Operator2 op2 = () -> System.out.println(k);

		String s = "Shivam";

		print2 p = q -> q.charAt(0) + q.replaceFirst(String.valueOf(q.charAt(0)), "");
		p.print(s);

	} // end of main method

	interface print2 {

		String print(String s);
	}

	interface add2 {

		int print(int i, int j);
	}

	public static Stream<String> toUpperCase(Stream<String> str) {
		return str.map(String::toUpperCase);
	}

	public static ArrayList<String> SampleList() {
		ArrayList<String> arr = new ArrayList<>();

		for (int i = 1; i <= 1000; i++) {
			arr.add("" + i);
		}
		return arr;
	}

	public static void printCertainElements(Stream<String> str1) {
		// Basically a comparator is a function
		str1.sorted((s1, s2) -> s1.compareTo(s2)).forEach((e) -> System.out.println(e));
	}

	// jdk 9 methods
	public static Stream<Integer> dropSomeElements(Stream<Integer> inStream) {
		return inStream.dropWhile(IntegerPred);
	}

	public Stream<Entity> returnEntitystream() {
		// Stream.generate();
		return null;
	}

	private class Entity {

		public Entity(String id, String name) {
			this.id = id;
			this.name = name;

		}

		private String id;
		private String name;

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

	}

}
