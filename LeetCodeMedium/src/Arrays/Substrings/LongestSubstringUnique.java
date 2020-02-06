package Arrays.Substrings;

import java.util.Arrays;

public class LongestSubstringUnique {
	public static int lengthOfLongestSubstring(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}

		char[] c = s.toCharArray();
		int[] chars = new int[256];
		Arrays.fill(chars, 0);
		int maxLength = 0;
		int ws = 0, we = 0;

		for (we = 0; we < c.length; we++) {
			if (chars[(int) c[we]] == 0) {
				maxLength = Math.max(maxLength, we - ws + 1);
			} else {
				while(ws<we&&(chars[(int) c[ws]]<=1)) {
					chars[(int) c[ws]]--;
					ws++;
				}
				
				maxLength = Math.max(maxLength, we - ws + 1);
			}
			chars[(int) c[we]]++;
		}

		return maxLength;

	}

	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring("aabaab!bb"));
	}
}
