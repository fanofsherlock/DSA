package structural.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class TimingInvocationHandler implements InvocationHandler {

	private Object realObject;

	public TimingInvocationHandler(Object obj) {
		realObject = obj;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

		long startTime = System.currentTimeMillis();
		Object result = method.invoke(realObject, args);
		long endTime = System.currentTimeMillis();
		System.out.println("Time to execute method :" + (endTime - startTime));
		return result;
	}
}


