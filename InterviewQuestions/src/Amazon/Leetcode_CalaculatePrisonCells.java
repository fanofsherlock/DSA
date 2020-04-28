package Amazon;
import java.util.*;
import java.util.stream.*;

public class Leetcode_CalaculatePrisonCells {

	// METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
	public List<Integer> cellCompete(int[] states, int days) {
		int[] next = new int[states.length];
		for (int i = 0; i < days; i++) {
			next = nextDay(states);
			states = next;
		}

		return Arrays.stream(states).boxed().collect(Collectors.toList());
	}

	public int[] nextDay(int[] states) {
		int[] temp = new int[states.length];
		temp[0] = states[1] == 0 ? 0 : 1;
		temp[7] = states[6] == 0 ? 0 : 1;

		for (int i = 1; i <= 6; i++) {
			temp[i] = states[i - 1] == states[i + 1] ? 0 : 1;
		}

		return temp;
	}

}
