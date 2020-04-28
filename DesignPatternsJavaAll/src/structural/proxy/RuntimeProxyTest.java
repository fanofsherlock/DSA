package structural.proxy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RuntimeProxyTest {
	
	
	public static void main(String[] args) {

		@SuppressWarnings("unchecked")
		Map<String, String> map = (Map<String, String>) RunTimeProxyInstances
				.getNewInstance(new HashMap<String, String>());

		map.put("key ", "value");
		map.put("key2 ", "value2");

		@SuppressWarnings("unchecked")
		List<String> list = (List<String>) RunTimeProxyInstances.getNewInstance(new ArrayList<String>());
		list.add("list1");
		list.add("list2");
		list.add("list3");
		

	}
}
