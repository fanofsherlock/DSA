package structural.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ListMethodInvocator implements InvocationHandler {

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// Handling List interface implementations
		if (method.getName().contains("add")) {
			System.out.println("\nList add: ");
			System.out.println(args[0]);
			return true;
		}
		return null;
	}
}
