package creational.factory;

public class test {

	public static void main(String[] args) {
		
		factoryComponent fc = FactoryClass.getFactComponent("CC1");
		System.out.println(fc.factoryName());
	}
}
