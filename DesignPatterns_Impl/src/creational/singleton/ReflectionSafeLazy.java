package creational.singleton;

public class ReflectionSafeLazy {

	private static ReflectionSafeLazy instance = new ReflectionSafeLazy();

	private ReflectionSafeLazy() {
		if (instance != null) {
			throw new IllegalStateException("Instance is already created");
		}
	}

	static ReflectionSafeLazy getInstance() {
		return instance;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}

}
