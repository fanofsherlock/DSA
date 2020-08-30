package PalindromicSubseq;

public class LongestPalindromicSubseq {

	public int longestPalindromeSubseq(String s) {
		Integer[][] dp = new Integer[s.length()][s.length()];
		return helper(s, 0, s.length() - 1, dp);
	}

	public int helper(String s, int start, int end, Integer[][] dp) {
		if (start > end) {
			return 0;
		}

		// Single character string
		if (start == end) {
			return 1;
		}

		if (dp[start][end] != null) {
			return dp[start][end];
		}

		// if charcters on then are equal
		if (s.charAt(start) == s.charAt(end)) {
			return 2 + helper(s, start + 1, end - 1, dp);
		}

		// delete first char
		int len1 = helper(s, start + 1, end, dp);
		// delete last char
		int len2 = helper(s, start, end - 1, dp);

		dp[start][end] = Math.max(len1, len2);
		return dp[start][end];
	}

}
