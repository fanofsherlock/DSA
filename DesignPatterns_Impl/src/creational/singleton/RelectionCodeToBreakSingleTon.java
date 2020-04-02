package creational.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class RelectionCodeToBreakSingleTon {

	public static void main(String[] args) {
		BrokenLazy br = BrokenLazy.getInstance();

		//Since hashcode of following objects is different means we have created two instances
		try {
			Constructor<BrokenLazy> con = BrokenLazy.class.getDeclaredConstructor(new Class[0]);
			con.setAccessible(true);
			BrokenLazy br2 = con.newInstance();
			System.out.println(br.hashCode());
			System.out.println(br2.hashCode());
		} catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException
				| IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
		
		
		
	}
}
