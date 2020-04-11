package structural.proxy;

import java.lang.reflect.Proxy;




public class compiletTimeProxy implements complexExpensiveObject {

	private complexExpensiveObject obj;

	public compiletTimeProxy() {
		obj = new realComplexObjectImpl();
	}

	@Override
	public void expensive1(String s) {
		obj.expensive1(s);
	}

	@Override
	public void expensive2(String s) {
		obj.expensive2(s);
	}

	@Override
	public void expensive3(String s) {
		obj.expensive3(s);
	}
}


