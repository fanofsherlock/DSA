package dynamicProg;

import java.util.Arrays;
import java.util.Scanner;

class Knapsack {

	static int calls = 0;
	static Object lock = new Object();

	public int solveKnapsack(int[] profits, int[] weights, int capacity) {
		Integer[][] dp = new Integer[capacity + 1][profits.length];
		return this.knapsackRecursive(profits, weights, capacity, 0, dp);
	}

	private int knapsackRecursive(int[] profits, int[] weights, int capacity, int currentIndex, Integer[][] dp) {

		synchronized (lock) {
			calls++;
		}

		if (capacity <= 0 || currentIndex >= profits.length) {
			return 0;
		}

		if (dp[capacity][currentIndex] != null) {
			return dp[capacity][currentIndex];
		}

		int profit1 = 0, profit2 = 0;

		if (weights[currentIndex] <= capacity) {
			//System.out.print("Call 1 :(" + capacity + "," + currentIndex + ") ");
			profit1 = profits[currentIndex]
					+ knapsackRecursive(profits, weights, capacity - weights[currentIndex], currentIndex + 1, dp);
			//System.out.println("Profit1 :" + profit1);
		}
		//System.out.print("Call 2 :(" + capacity + "," + currentIndex + ") ");
		profit2 = knapsackRecursive(profits, weights, capacity, currentIndex + 1, dp);
		//System.out.println("Profit2 :" + profit2);

		dp[capacity][currentIndex] = Math.max(profit1, profit2);

		return dp[capacity][currentIndex];

	}

	public static void main(String[] args) {
		Knapsack ks = new Knapsack();
		int[] profits = { 1, 6, 10, 16 };
		int[] weights = { 1, 2, 3, 5 };

		int maxProfit = ks.solveKnapsack(profits, weights, 7);
		System.out.println("\n\nTotal knapsack profit ---> " + maxProfit);
		System.out.println("Total calls: " + calls);
		// maxProfit = ks.solveKnapsack(profits, weights, 6);
		// System.out.println("Total knapsack profit ---> " + maxProfit);
	}
}
