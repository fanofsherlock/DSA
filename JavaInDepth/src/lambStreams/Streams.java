package lambStreams;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
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

		// GENERATING, BUILDING and STREAMING COLLECITONS
		IntStream.rangeClosed(1, 10).parallel().forEachOrdered(System.out::println);

		System.exit(1);
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

		// Intermediate functions
		List<String> list = new ArrayList<String>();
		System.out.println(list.stream().anyMatch(s -> s.length() > 1));
		System.out.println(list.stream().allMatch(s -> s.length() > 1));
		System.out.println(list.stream().noneMatch(s -> s.length() > 1));

		Stream<Double> stream = Stream.generate(() -> Double.parseDouble("1.0"));
		System.out.println(stream.findFirst());

		// Optional Class
		Optional<Integer> optional = Optional.ofNullable(null);
		System.out.println(optional.orElse(-1));
		Stream<Integer> testStream = Stream.of(10, 0, -10);
		System.out.println(testStream.findAny().get());
		Stream<LocalDate> stream2 = Stream.of(LocalDate.of(2018, 1, 1), LocalDate.of(2018, 1, 1));
		Optional<LocalDate> optional2 = stream2.distinct().findAny();
		System.out.println(optional2.isPresent() + " : " + optional2.get());
		OptionalLong optional3 = OptionalLong.empty();
		// System.out.println(optional3.isPresent() + " : " + optional3.getAsLong());

		// INT/LONG/DOUBLE STREAMS
		IntStream stream4 = IntStream.generate(() -> new Random().nextInt(100)).limit(5);
		stream4.filter(i -> i > 0 && i < 10).findFirst().ifPresent(System.out::println);
		;
		IntStream stream5 = new Random().ints(1, 7).limit(2);
		System.out.println(stream5.max().getAsInt());

		IntStream.range(1, 10).forEach(System.out::print);
		System.out.println();
		LongStream.iterate(0, i -> i + 2).limit(4).forEach(System.out::print);
		System.out.println();

		Stream<Integer> stream6 = Arrays.asList(1, 2, 3, 4, 5).stream();
		System.out.println(stream6.mapToInt(e -> e).summaryStatistics());

		LongStream stream7 = LongStream.empty();
		System.out.println(stream7.average());

		DoubleStream sts = new Random(100).doubles();
		sts.filter(s -> s > 0.65).map(e -> e * e).limit(10).forEach(s -> System.out.println(s));

		DoubleStream int1 = DoubleStream.generate(() -> Math.random()).distinct().limit(20);
		System.out.println(int1.reduce(0, (i, j) -> i + j));

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
		list.stream().collect(Collectors.groupingBy(String::length));
	}

}
