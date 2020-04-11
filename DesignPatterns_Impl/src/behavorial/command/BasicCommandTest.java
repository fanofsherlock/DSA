package behavorial.command;

public class BasicCommandTest {

	public static void main(String[] args) {
		Light light = new Light();
		Command com = new ConcreteCommand(light);
		Invoker Switch = new SwitchLightInvoker();

		Switch.executeCommand(com);

	}
}
