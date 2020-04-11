package structural.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MapMethodInvocator implements InvocationHandler {


	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

		// Handling Map Interface methods
		if (method.getName().contains("put")) {
			System.out.println("\nMap put: ");
			System.out.println(args[0] + " " + args[1]);
			return args[1];// return type should match the original methods return type
		}

		return null;
	}

}


