package DyanamicProgramming;

public class ClimbingStairs70 {

	public int climbStairs(int n) {
		return climbStairsHelper(n, 0, new Integer[n]);
	}

	public int climbStairsHelper(int n, int paths, Integer[] dp) {
		if (n == 0) {
			return paths + 1;
		} else if (n < 0) {
			return paths;
		}

		if (dp[n - 1] != null) {
			return dp[n - 1];
		}

		int path1 = climbStairsHelper(n - 1, paths, dp);
		int path2 = climbStairsHelper(n - 2, paths, dp);
		dp[n - 1] = path1 + path2;

		return dp[n - 1];
	}

}
