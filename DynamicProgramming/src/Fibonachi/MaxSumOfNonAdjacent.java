package Fibonachi;

public class MaxSumOfNonAdjacent {

	static int maxSubsetSum2(int[] arr) {
		if (arr == null || arr.length == 0) {
			return 0;
		}

		if (arr.length == 1) {
			return arr[0];
		}
		Integer[] dp = new Integer[arr.length];
		dp[0] = arr[0];
		dp[1] = Math.max(arr[0], arr[1]);

		for (int i = 2; i < arr.length; i++) {
			dp[i] = Math.max(arr[i], Math.max(arr[i] + dp[i - 2], dp[i - 1]));
		}

		return dp[arr.length - 1];
	}

	
	
	static int maxSubsetSum(int[] arr) {
		if (arr == null || arr.length == 0) {
			return 0;
		}

		Integer[] dp = new Integer[arr.length];
		return helper(arr, 0, dp);

	}

	private static int helper(int[] arr, int curIndex, Integer[] dp) {
		if (curIndex >= arr.length) {
			return 0;
		}

		if (dp[curIndex] != null) {
			return dp[curIndex];
		}

		// Taking current element
		int sum1 = arr[curIndex] + helper(arr, curIndex + 2, dp);
		// Not taking current element
		int sum2 = helper(arr, curIndex + 1, dp);

		dp[curIndex] = Math.max(sum1, sum2);
		return dp[curIndex];
	}

	public static void main(String[] args) {
		int[] a2 = new int[] { 3, 5, -7, 8, 10 };
		System.out.println(maxSubsetSum2(a2));
	}

}
