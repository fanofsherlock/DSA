package cars24;

import java.util.ArrayList;
import java.util.List;

public final class TestImmutableClass {
	List<String> containedStrings;
	
	public TestImmutableClass(List<String> containedStrings) {
		this.containedStrings = new ArrayList<String>(containedStrings);
	}

	
	public List<String> getContainedStrings() {
		return new ArrayList<String>(containedStrings);
	}

}
