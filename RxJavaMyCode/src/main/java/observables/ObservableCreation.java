package observables;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import io.reactivex.Observable;

public class ObservableCreation {

	public static void main(String[] args) {
		// Common classes
		ExecutorService es = Executors.newFixedThreadPool(1);
		int[] arr = IntStream.range(0, 0 + 10).toArray();
		Integer[] res = Arrays.stream(arr).boxed().toArray(Integer[]::new);
		
		
		
		// Create an observable from upto 10 single items
		Observable<Integer> ob1 = Observable.just(1, 2, 3);

		// Create Observable from several from methods
		Observable<Integer> ob2 = Observable.fromArray(res);
		Observable<Integer> ob3 = Observable.fromIterable(Arrays.asList(res));
		Observable<Integer> ob4 = Observable.fromCallable(() -> 1);
		Observable<Integer> ob5 = Observable.fromFuture(es.submit(() -> 2));
		// Observable<Integer> ob5 = Observable.fromPublisher();

		ob1.subscribe(e -> System.out.println(e));
		es.shutdown();
		System.exit(0);

	}

}
