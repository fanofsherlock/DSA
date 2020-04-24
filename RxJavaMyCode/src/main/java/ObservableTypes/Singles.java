package ObservableTypes;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.disposables.Disposable;

public class Singles {

	public static void main(String[] args) {

		Observable<Integer> integerObservable = Observable.range(1, 10);

		// Observable
		Observable<Integer> evenIntegers = integerObservable.filter(e -> e % 2 == 0);
		evenIntegers.subscribe(e -> System.out.println("Current value :" + e),
				t -> System.out.println("Error :" + t.getMessage()));

		// Single - Any
		Single<Boolean> greaterThanTwo = integerObservable.any(i -> i > 2);
		greaterThanTwo.subscribe(suc -> System.out.println("Has vallues greater than 2: " + suc),
				t -> System.out.println(t.getMessage()));

	}

}
