package creational.factory;

import java.util.HashMap;

public class AbstractFactory {

	Integer i;

	HashMap<String, FactoryInterface> map = new HashMap<String, FactoryInterface>();

	public void registerFactory(String factoryType, FactoryInterface v) {
		map.put(factoryType, v);
	}

	public factoryComponent getComponent(String componentType, String parameter) {

		factoryComponent result = null;

		if (map.containsKey("factName")) {
			result = map.get(componentType).getFactComponent(parameter);
		} else {
			return result;
		}

		return result;
	}

}
