package ObservableTypes;

import io.reactivex.MaybeObserver;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class Maybe {

	public static void main(String[] args) {

		Observable<Integer> integerObservable = Observable.range(1, 10);

		// Maybe
		io.reactivex.Maybe<Integer> sumOfAllValues = integerObservable.reduce((a, b) -> a + b);

		@SuppressWarnings({ "rawtypes", "unchecked" })

		MaybeObserver<Integer> maybe = new MaybeObserver() {
			
			@Override
			public void onSubscribe(Disposable d) {
				System.out.println("Subscirbed");
				// d.dispose();
			}
			
			
			@Override
			public void onError(Throwable e) {
				System.out.println("Error");

			}
			

			@Override
			public void onSuccess(Object t) {
				System.out.println("Success: " + t);
			}
			
			
			@Override
			public void onComplete() {
				System.out.println("Completed");
			}
		};

		Observer<String> obs = new Observer<String>() {

			@Override
			public void onSubscribe(Disposable d) {
             //First
			}
			
			@Override
			public void onError(Throwable e) {
				//Only in case of error
			};

			

			@Override
			public void onComplete() {

			}

			
			@Override
			public void onNext(String t) {
			};

		
			
		};

		sumOfAllValues.subscribe(maybe);
	}

}
