package creational.factory;

public class FactoryClass {

	static factoryComponent getFactComponent(String val) {
		
		factoryComponent fc = null;// in case of no match

		switch (val) {
		case "CC1":
			fc = new ConcreteComponent1();
			break;

		case "CC2":
			fc = new ConcreteComponent2();
			break;
		}
		return fc;
	}
}


