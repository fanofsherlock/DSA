package Arrays;

import java.util.Arrays;
import java.util.List;

public class MaxDistance {

	//SOLUTION 1
	public int maximumGap(final List<Integer> a) {
		int maxDiff = 0;
		int i = 0, j = 0;
		int[] leftMin = new int[a.size()];
		int[] rightMax = new int[a.size()];

		leftMin[0] = a.get(0);
		for (i = 1; i < a.size(); i++) {
			leftMin[i] = Math.min(leftMin[i - 1], a.get(i));
		}

		rightMax[a.size() - 1] = a.get(a.size() - 1);
		for (j = a.size() - 2; j >= 0; j--) {
			rightMax[j] = Math.max(rightMax[j + 1], a.get(j));

		}

		i = 0;
		j = 0;
		while (j < a.size() && i < a.size()) {
			if (leftMin[i] <= rightMax[j]) {
				maxDiff = Math.max(j - i, maxDiff);
				j++;
			} else {
				i++;

			}
		}

		return maxDiff;
	}

	// SOLUTION 2
	
	
	class Node implements Comparable<Node> {
		int n;
		int index;

		public Node(int number, int index) {
			this.n = number;
			this.index = index;
		}

		public int compareTo(Node o) {
			Integer a = this.n;
			Integer b = o.n;
			return a.compareTo(b);
		}
	}

	public int maximumGap(final int[] A) {
		Node[] nodes = new Node[A.length];
		for (int i = 0; i < A.length; i++) {
			nodes[i] = new Node(A[i], i);
		}
		Arrays.sort(nodes);

		int max = nodes[A.length - 1].index;

		for (int i = A.length - 1; i >= 0; i--) {

			if (nodes[i].index > max) {
				max = nodes[i].index;
			}
			nodes[i].n = max - nodes[i].index;

		}

		max = nodes[0].n;
		for (int i = 0; i < A.length; i++) {
			if (nodes[i].n > max) {
				max = nodes[i].n;

			}
		}
		return max;

	}

}

