package NextGrtOrSmaller;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class LC503_NGE_Circular {

	public int[] nextGreaterElements(int[] arr) {
		Deque<Integer> stack = new LinkedList<>();

		for (int i = arr.length - 1; i >= 0; i--) {
			stack.push(arr[i]);
		}

		int next = -1;
		int[] res = new int[arr.length];

		for (int i = arr.length - 1; i >= 0; i--) {
			next = -1;
			while (!stack.isEmpty() && stack.peek() <= arr[i]) {
				stack.pop();
			}

			if (!stack.isEmpty()) {
				next = stack.peek();
			}

			res[i] = next;
			stack.push(arr[i]);
		}

		return res;
	}

	public static void main(String[] args) {
		LC503_NGE_Circular lc = new LC503_NGE_Circular();
		System.out.println(Arrays.toString(lc.nextGreaterElements(new int[] { 1, 2, 1 })));
	}

}
