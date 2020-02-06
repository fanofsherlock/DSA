package Arrays;

public class CountAndSay {

	public String countAndSay(int n) {
		if (n <= 0) {
			return "";
		}
		if (n == 1) {
			return "1";
		}
		return cs(2, n, "11");
	}

	public String cs(int x, int n, String ans) {
		if (x == n) {
			return ans;
		}

		int count = 1;
		StringBuilder sb = new StringBuilder();
		int i = 1;
		for (i = 1; i < ans.length(); i++) {
			if (ans.charAt(i - 1) == ans.charAt(i)) {
				count++;
			} else {
				sb.append(count);
				sb.append(ans.charAt(i - 1));
				count = 1;
			}
		}

		if (count != 0) {
			sb.append(count);
			sb.append(ans.charAt(i - 1));
		}
		return cs(x + 1, n, sb.toString());
	}

}
