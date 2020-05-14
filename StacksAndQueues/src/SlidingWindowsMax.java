import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowsMax {

	public static int[] slid(int[] arr, int k) {

		int n = arr.length;

		// Stores results
		int startIndex = 0;
		int[] res = new int[n - k + 1];
		// Stores the index of maximum element in the window
		Deque<Integer> q = new LinkedList<Integer>();

		for (int i = 0; i < n; i++) {

			// Current window is only (i-(k-1) -i) long
			while (!q.isEmpty() && q.peek() < (i - k + 1)) {
				q.poll(); // can use PollLast also with same speed
			}

			// remove all elements which are smaller than the current element
			while (!q.isEmpty() && arr[q.peekLast()] < arr[i]) {
				q.pollLast();
			}

			q.offer(i);

			if (i >= k - 1) {
				res[startIndex++] = arr[q.peek()];
			}

		}

		return res;
	}

	public static void main(String[] args) {
		int[] arr = new int[] { 4, 5, 1, -1, -2, -3, 6, 7, 8 };
		System.out.println(Arrays.toString(slid(arr, 3)));

	}

}
