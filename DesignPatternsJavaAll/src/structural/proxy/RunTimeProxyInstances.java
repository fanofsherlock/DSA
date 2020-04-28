package structural.proxy;

import java.lang.reflect.Proxy;
import java.util.List;
import java.util.Map;

public class RunTimeProxyInstances {

	public static  Object getNewInstance(Object obj) {

		if (obj instanceof Map) {
			return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(),
					new MapMethodInvocator());
		}

		if (obj instanceof List) {
			return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(),
					new ListMethodInvocator());
		}

		return null;
	}

}


