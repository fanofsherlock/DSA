package creational.singleton;

import java.io.Serializable;

public class SerializationSafeSingleton implements Serializable {

	private static final long serialVersionUID = -7604766932017737115L;

	private SerializationSafeSingleton() {
	}

	private static class SerializationSafeSingletonHelper {
		public static final SerializationSafeSingleton instance = new SerializationSafeSingleton();
	}

	public SerializationSafeSingleton getInstance() {
		return SerializationSafeSingletonHelper.instance;
	}

	//ensures Serialization safety
	protected Object readResolve() {
		return getInstance();
	}

}





