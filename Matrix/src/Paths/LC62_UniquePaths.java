package Paths;

public class LC62_UniquePaths {
	public int uniquePaths(int m, int n) {
		Integer[][] dp = new Integer[m + 1][n + 1];
		return calcPaths(1, 1, m, n, dp);
	}

	public int calcPaths(int row, int col, int m, int n, Integer[][] dp) {
		/* Because robot can only move up or down */
		if (row == m || col == n) {
			return 1;
		}

		if (dp[row][col] != null) {
			return dp[row][col];
		}

		dp[row][col] = calcPaths(row + 1, col, m, n, dp) + calcPaths(row, col + 1, m, n, dp);
		return dp[row][col];
	}

}
