package cars24;

public class algo1 {

	/* 1 D kadene solution */
	public static int returnmaxSumRectangle(int[] arr) {
		if (arr == null || arr.length == 0) {
			return Integer.MIN_VALUE;
		}

		int curSum = 0;
		int maxSum = Integer.MIN_VALUE;
		int start = 0, end = 0;
		int maxStart = 0, maxEnd = 0;
		for (int i = 0; i < arr.length; i++) {
			curSum += arr[i];
			if (curSum <= 0) {
				start = i + 1;
				curSum = 0;
			}

			if (maxSum < curSum) {
				maxStart = start;
				end = i;
				maxEnd = end;
				maxSum = curSum;
			}
		}

		System.out.println("start :" + maxStart + " end :" + maxEnd);
		return maxSum;
	}

	/* 2 D kadene solution */
	private static int maxSumRectangle(int[][] matrix) {
		int m = matrix.length;
		int n = matrix[0].length;
		int prefixSum[][] = new int[m + 1][n];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				prefixSum[i + 1][j] = prefixSum[i][j] + matrix[i][j];
			}
		}

		int maximumSum = -1;
		int minimumSum = Integer.MIN_VALUE;
		int negRow = 0, negCol = 0;
		int tempRowStart = 0, tempRowEnd = 0, tempColStart = 0, tempColEnd = 0;

		for (int rowStart = 0; rowStart < m; rowStart++) {
			for (int row = rowStart; row < m; row++) {
				int sum = 0;
				int curColStart = 0;
				for (int col = 0; col < n; col++) {

					sum += prefixSum[row + 1][col] - prefixSum[rowStart][col];
					if (sum < 0) {
						if (minimumSum < sum) {
							minimumSum = sum;
							negRow = row;
							negCol = col;
						}
						sum = 0;
						curColStart = col + 1;
					} else if (maximumSum < sum) {
						maximumSum = sum;
						tempRowStart = rowStart;
						tempRowEnd = row;
						tempColStart = curColStart;
						tempColEnd = col;
					}
				}
			}
		}

		return maximumSum == -1 ? minimumSum : maximumSum;
	}

	public static void main(String[] args) {
		System.out.println(returnmaxSumRectangle(new int[] { -1, -2, -3, 2, 4, 3, 1, -6, -8 }));
	}

}
