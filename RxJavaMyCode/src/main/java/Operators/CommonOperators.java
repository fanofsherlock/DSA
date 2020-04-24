package Operators;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;

public class CommonOperators {

	public static void main(String[] args) {
		String[] strings = new String[] { "Papa", "Mummy", "Shivam", "Anupriya", "Yamini" };
		Observable<String> observable = Observable.fromArray(strings);

		// Concat Map
		observable.concatMap(e -> new ObservableSource<String>() {
			@Override
			public void subscribe(Observer<? super String> observer) {
				observer.onNext(e);
			}
		});// .subscribe(e->System.out.println(e));

		// Map
		observable.map(e -> e.toUpperCase()).subscribe(e -> System.out.println(e));

		// Scan
		String[] letters = { "a", "b", "c" };
		String result = "";
		Observable.fromArray(letters).scan(new StringBuilder(), StringBuilder::append)
				.subscribe(total -> System.out.println(total.toString()));

	}

}
