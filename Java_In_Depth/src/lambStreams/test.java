package lambStreams;

import java.util.function.DoublePredicate;
import java.util.function.Predicate;

public class test {

	public static void main(String[] args) {
		CustomPredicate<String> pred = x -> x.equals("");
		Predicate<String> pred2 = x -> x.equals("qbc");
		Predicate<String> pred3 = x -> x.equals("xyz");
		Predicate<String> pred4 = pred2.and(pred3);

		DoublePredicate dubPred = (x) -> x < 1000.234;
		Predicate<Double> pred5 =(x) -> x < 1000.234;

	}

}
