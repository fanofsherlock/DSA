package ObservableTypes;

import io.reactivex.Observable;

public class ObservableType {

	public static void main(String[] args) {
		Observable<Integer> integerObservable = Observable.range(1, 10);

		// Observable
		Observable<Integer> evenIntegers = integerObservable.filter(e -> e % 2 == 0);
		evenIntegers.subscribe(e -> System.out.println("Current value :" + e),
				t -> System.out.println("Error :" + t.getMessage()));

	}

}
