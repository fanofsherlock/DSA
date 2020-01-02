package dynamicProg;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LIS {

	public static void main(String[] args) {
		int[] arr = new int[] { 1, 2, 1, 5 };
		System.out.println(lis(Arrays.stream(arr).boxed().collect(Collectors.toList())));
	}

	private static int lis(final List<Integer> A) {
		int[] dp = new int[A.size() + 1];
		int ans = 0;
		
		for (int i = 0; i < A.size(); i++) {
			int m = 0;
			for (int k = i - 1; k >= 0; k--) {

				if (A.get(k) < A.get(i)) {
					m = Math.max(m, dp[k]);
				}
			}
			dp[i] = m + 1;
			ans = Math.max(ans, dp[i]);
		}//end of loop

		return ans;
	}

}
