package behavorial.command;

public class ConcreteCommand implements Command {

	private Light light;

	public ConcreteCommand(Light light) {
		this.light = light;
	}

	@Override
	public void execute() {
		light.switchOn();
	}
}
