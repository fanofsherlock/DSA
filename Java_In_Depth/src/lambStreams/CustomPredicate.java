package lambStreams;

@FunctionalInterface
public interface CustomPredicate<T> {

	boolean test(T obj);

	default boolean test2(T obj) {
		return false;
	}

}
