package creational.factory;

public interface factoryComponent {
	default String factoryName() {
		return "factory 1 Imlementation";
	}

	String returnName();

}
