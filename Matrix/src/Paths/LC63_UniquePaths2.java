package Paths;

public class LC63_UniquePaths2 {
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {

		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;
		Integer[][] dp = new Integer[m + 1][n + 1];
		return calcPaths(1, 1, m, n, obstacleGrid, dp);
	}

	public int calcPaths(int row, int col, int m, int n, int[][] obstacleGrid, Integer[][] dp) {
		/* Because robot can only move up or down */
		if (obstacleGrid[row - 1][col - 1] == 1) {
			return 0;
		} else if (row == m && col == n) {
			return 1;
		}

		if (dp[row][col] != null) {
			return dp[row][col];
		}

		int path1 = 0;
		if (row < m) {
			path1 = calcPaths(row + 1, col, m, n, obstacleGrid, dp);
		}
		int path2 = 0;
		if (col < n) {
			path2 = calcPaths(row, col + 1, m, n, obstacleGrid, dp);
		}

		dp[row][col] = path1 + path2;
		return dp[row][col];
	}
}
