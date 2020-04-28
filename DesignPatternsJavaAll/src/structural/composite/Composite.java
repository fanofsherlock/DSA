package structural.composite;

import java.util.ArrayList;
import java.util.List;

public class Composite implements Component {
	List<Component> components;

	public Composite() {
		components = new ArrayList<Component>();
	}

	@Override
	public void performWork(String task) {
		components.forEach(e -> e.performWork(task));
	}

	void registerComponent(Component c) {
		components.add(c);
	}

	void deregisterComponent(Component c) {
		components.remove(c);
	}
}




