package Array;

import java.util.PriorityQueue;

public class BuyAndSellStock4 {

	public static int maxProfit(int K, int[] prices) {
		if (prices == null || prices.length < 2 || K > prices.length - 1 || K < 1) {
			return 0;
		}

		// Max transaction on or before current stock
		int[] leftMaxTransc = new int[prices.length];
		int min = Integer.MAX_VALUE;
		int res = 0;

		for (int i = 0; i < prices.length; i++) {
			res = Math.max(res, prices[i] - min);
			min = Math.min(min, prices[i]);
			leftMaxTransc[i] = res;
		}

		// minHeap
		PriorityQueue<Integer> q = new PriorityQueue<Integer>((a, b) -> a - b);

		for (int i = 0; i < prices.length; i++) {
			if (i < K) {
				q.add(leftMaxTransc[i]);
			} else {
				if (leftMaxTransc[i] > q.peek()) {
					q.poll();
					q.add(leftMaxTransc[i]);
				}
			}
		}

		int maxProfit = 0;
		while (!q.isEmpty()) {
			maxProfit += q.poll();
		}

		return maxProfit;
	}
	
	public static void main(String[] args) {
		System.out.println(maxProfit(2, new int[] {2,4,1}));
	}

}
