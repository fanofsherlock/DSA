package sliding_window;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;

public class SlidingWindowMaximum {

	public int[] heap(int[] nums, int k) {
		if (nums == null || nums.length == 0 || k < 1) {
			return new int[] {};
		}

		int[] maxVal = new int[nums.length - k + 1];
		PriorityQueue<Integer> maxQ = new PriorityQueue<>((a, b) -> b - a);

		for (int i = 0; i < k; i++) {
			maxQ.add(nums[i]);
		}

		int ws = 0;
		maxVal[0] = maxQ.peek();
		int index = 0;
		for (int we = k; we < nums.length; we++) {
			if (nums[ws] >= maxQ.peek()) {
				maxQ.poll();
			}
			ws++;
			maxQ.add(nums[we]);
			maxVal[++index] = maxQ.peek();
		}

		return maxVal;
	}

	public int[] queue(int[] a, int k) {
		if (a == null || k <= 0) {
			return new int[0];
		}
		int n = a.length;
		int[] r = new int[n - k + 1];
		int ri = 0;

		// store index
		Deque<Integer> q = new ArrayDeque<>();
		for (int i = 0; i < a.length; i++) {
			// remove numbers out of range k
			while (!q.isEmpty() && q.peek() < i - k + 1) {
				q.pollFirst();
			}
			// remove smaller numbers in k range as they are useless
			while (!q.isEmpty() && a[q.peekLast()] < a[i]) {
				q.pollLast();
			}
			// q contains index... r contains content
			q.offer(i);
			if (i >= k - 1) {
				r[ri++] = a[q.peek()];
			}
		}
		return r;
	}

	public static int[] array(final int[] in, final int w) {
		final int[] max_left = new int[in.length];
		final int[] max_right = new int[in.length];

		max_left[0] = in[0];
		max_right[in.length - 1] = in[in.length - 1];

		for (int i = 1; i < in.length; i++) {
			max_left[i] = (i % w == 0) ? in[i] : Math.max(max_left[i - 1], in[i]);

			final int j = in.length - i - 1;
			max_right[j] = (j % w == 0) ? in[j] : Math.max(max_right[j + 1], in[j]);
		}

		final int[] sliding_max = new int[in.length - w + 1];
		for (int i = 0, j = 0; i + w <= in.length; i++) {
			sliding_max[j++] = Math.max(max_right[i], max_left[i + w - 1]);
		}

		return sliding_max;
	}
}
