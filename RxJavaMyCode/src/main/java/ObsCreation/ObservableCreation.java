package ObsCreation;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class ObservableCreation {

	public static void main(String[] args) throws InterruptedException {

		List<Integer> list = Stream.iterate(1, i -> i + 1).limit(10).collect(Collectors.toList());
		Observable<Integer> observable = Observable.fromIterable(list);

		
		Thread.sleep(2000);

		Observer<Integer> sub = new Observer<Integer>() {
			@Override
			public void onComplete() {
				System.out.println("Completed");

			}

			@Override
			public void onError(Throwable e) {
				System.out.println("Error: " + e.getMessage());

			}

			@Override
			public void onNext(Integer t) {
				System.out.println("Next: " + t);

			}

			@Override
			public void onSubscribe(Disposable d) {
				System.out.println("Subscirbed to: " + d.toString());

			}
		};

		observable.subscribe(sub);

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
