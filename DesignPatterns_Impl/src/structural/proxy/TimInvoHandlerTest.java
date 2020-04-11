package structural.proxy;

import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TimInvoHandlerTest {

	public static void main(String[] args) {
		List<Integer> list1 = Stream.iterate(0, i -> i + 1).limit(500000).collect(Collectors.toList());
		List<Integer> list2 = Stream.iterate(0, i -> i + 1).limit(50000).collect(Collectors.toList());

		List<Integer> test = (List<Integer>) Proxy.newProxyInstance(ArrayList.class.getClassLoader(),
				ArrayList.class.getInterfaces(), new TimingInvocationHandler(new ArrayList<>()));

	    test.addAll(list1);
	    test.addAll(list2);
	    test.add(11);
	}

}
