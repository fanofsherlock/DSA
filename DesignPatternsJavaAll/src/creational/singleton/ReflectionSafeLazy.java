package creational.singleton;

public class ReflectionSafeLazy {

	private static volatile ReflectionSafeLazy instance;
	private static Object lock = new Object();

	private ReflectionSafeLazy() {
		if (instance != null) {
			throw new IllegalStateException("Instance is already created");
		}
	}

	public static ReflectionSafeLazy getInstance() {
		if (instance == null) {
			synchronized (lock) {
				if (instance == null) {
					instance = new ReflectionSafeLazy();
				}
			}
		}
		return instance;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}

}
