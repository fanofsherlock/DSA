package Basic;

import java.util.*;

public class KthSmallestInMSortedArrays {

	public static int findKthSmallest(List<Integer[]> lists, int k) {
		PriorityQueue<Integer> p = new PriorityQueue<Integer>((a, b) -> b - a);
		int n = lists.size();
		Integer[] a;
		long count = 0;

		for (int i = 0; i < n; i++) {
			
			a = lists.get(i);
			
			for (int j : a) {
				if (count > k-1 && j < p.peek()) {
					p.poll();
					p.add(j);

				} else {
					p.add(j);
				}
				count++;
			}

		}

		return p.peek();
	}

	public static void main(String[] args) {
		Integer[] l1 = new Integer[] { 2, 6, 8 };
		Integer[] l2 = new Integer[] { 3, 6, 7 };
		Integer[] l3 = new Integer[] { 1, 3, 4 };
		List<Integer[]> lists = new ArrayList<Integer[]>();
		lists.add(l1);
		lists.add(l2);
		lists.add(l3);
		int result = KthSmallestInMSortedArrays.findKthSmallest(lists, 5);
		System.out.print("Kth smallest number is: " + result);
	}
}
