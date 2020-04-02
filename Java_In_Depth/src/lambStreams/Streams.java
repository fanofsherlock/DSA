package lambStreams;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.OptionalLong;
import java.util.Random;
import java.util.Spliterator;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Streams {

	public static void main(String[] args) {


		// Boolean Property Check
		List<String> list = new ArrayList<String>();
		System.out.println(list.stream().anyMatch(s -> s.length() > 1));
		System.out.println(list.stream().allMatch(s -> s.length() > 1));
		System.out.println(list.stream().noneMatch(s -> s.length() > 1));

		
		


		//Converting Int array into Integer Array
		IntStream stream4 = IntStream.generate(() -> new Random().nextInt(100)).limit(5);
		stream4.filter(i -> i > 0 && i < 10).boxed().toArray(Integer[]::new);
		
		
	
		
		
		

		// reduce
		List<String> letters = Arrays.asList("a", "b", "c", "d", "e");
		String result = letters.stream().reduce("", (partialString, element) -> partialString + element.toUpperCase());
		print(result);

		// flatmap
		List<String> list2 = new ArrayList<String>();
		List<String> list3 = new ArrayList<String>();
		List<String> list4 = new ArrayList<String>();
		List<String> list5 = new ArrayList<String>();
		list2.add("1000");
		list3.add("2000");
		list4.add("3000");
		list5.add("4000");
		list2.add("1000");
		list3.add("2000");
		list4.add("3000");
		list5.add("4000");
		List<List<String>> listOFLists = new ArrayList<List<String>>();
		listOFLists.add(list5);
		listOFLists.add(list3);
		listOFLists.add(list2);
		listOFLists.add(list4);

		listOFLists.stream().flatMap(e -> e.stream().map(t -> t + "2000")).forEach(System.out::println);
		;

	}

	static void print(String s) {
		System.out.println(s);
	}

	static void genStream() {
		// GENERATING, BUILDING and STREAMING COLLECITONS
		IntStream.rangeClosed(1, 10).parallel().forEachOrdered(System.out::print);

		// generating
		Stream.generate(() -> Math.random());
		Stream.iterate(0, i -> i + 2);
		Stream.ofNullable(null);
		Stream.of(1, 2, 3, 4, 5);

		// building
		Stream.Builder<Integer> strBuild = Stream.builder();
		strBuild.accept(30);
		strBuild.accept(40);
		strBuild.accept(50);
		Stream<Integer> intStream = strBuild.build();
		intStream.allMatch(e -> e > 0);

		// streaming arrays
		Arrays.stream(new int[] { 1, 2, 3 });
		Stream.of(new int[] { 1, 2, 3 });
		Arrays.asList(1, 2, 3, 4).stream();

		// streaming list and sets
		new ArrayList<String>().stream();
		new HashSet<String>().stream();

		// streaming maps
		new HashMap<String, Integer>();

	}

	static void splitIteratorEx(ArrayList<Integer> list) {
		Spliterator<Integer> s = list.stream().spliterator();
		s.getComparator();

		// for remaining elements
		s.forEachRemaining(System.out::println);
		s.tryAdvance(e -> System.out.println(e));

		// size of the stream
		s.estimateSize();
		s.getExactSizeIfKnown();

	}

	static void databaseOperations(ArrayList<String> list) {
		// Group By
		list.stream().collect(Collectors.groupingBy(String::length));

		// Order By
		Comparator<String> comp = Comparator.comparing((String e) -> e.charAt(0))
				.thenComparing((String e) -> e.length());
		list.sort(comp);
	}

}
