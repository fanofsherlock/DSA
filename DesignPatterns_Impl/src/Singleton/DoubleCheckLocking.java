package Singleton;

public class DoubleCheckLocking {

	private static volatile DoubleCheckLocking instance;

	private DoubleCheckLocking() {
		// TODO Auto-generated constructor stub
	}

	public static DoubleCheckLocking getInstance() {

		if (instance == null) {//first check

			synchronized (DoubleCheckLocking.class) {
				if (instance == null) {//second check 
					instance = new DoubleCheckLocking();
				}
			}

		}

		return instance;

	}
}
