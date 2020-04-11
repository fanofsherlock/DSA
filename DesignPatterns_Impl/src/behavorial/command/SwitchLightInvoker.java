package behavorial.command;

public class SwitchLightInvoker implements Invoker {

	@Override
	public void executeCommand(Command command) {
		command.execute();
	}
}
