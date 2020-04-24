package ObservableTypes;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

public class CompletableType {

	public static void main(String[] args) {
		Observable<Integer> integerObservable = Observable.empty();

		Completable completable = integerObservable.ignoreElements();

		CompletableObserver completableObserver = new CompletableObserver() {
			@Override
			public void onSubscribe(Disposable d) {
				System.out.println("onSubscribe");
			}

			@Override
			public void onComplete() {
				System.out.println("onComplete");
			}

			@Override
			public void onError(Throwable e) {
				System.out.println("onError");
			}
		};

		completable.subscribe(completableObserver);

	}

}
