package Maps;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Test_MyHashMap {
	static MyHashMap<String, Integer> map = new MyHashMap<String, Integer>(32);

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testSize() {
		map.put("a", 1);
		map.put("a", 1);
		map.put("a", 1);

		assertEquals(map.size(), 1);

	}

	@Test
	void testContains() {
		assertTrue(map.containsKey("a"));
	}

	@Test
	void testContains2() {
		assertFalse(map.containsKey("b"));
	}

	@Test
	void testRemove() {
		map.put("b", 2);
		map.put("c", 3);
		map.put("d", 4);

		map.remove("d");

		assertFalse(map.containsKey("d"));
	}

	void testResizing() {
		map.put("e", 5);
		map.put("f", 6);
		map.put("g", 7);

		map.put("h", 5);
		map.put("i", 6);
		map.put("j", 7);

		map.put("k", 5);
		map.put("l", 6);
		map.put("m", 7);

		map.put("n", 5);
		map.put("o", 6);
		map.put("p", 7);

		map.put("q", 5);
		map.put("r", 6);
		map.put("s", 7);

	}

}
