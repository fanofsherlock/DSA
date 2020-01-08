package Optional;

import java.util.Optional;

public class OptionalTest {
	static Person p1;

	public static void main(String[] args) {

		Person p2 = new OptionalTest().new Person();
 		Optional<Person> op = Optional.of(p2);
        
 		
	}

	class Person {

	}

}
