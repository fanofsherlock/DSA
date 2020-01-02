package dynamicProg;

public class editDistance {

	public int minDistance(String A, String B) {
		return solve(A, B, A.length(), B.length());
	}

	public static int solve(String A, String B, int a, int b) {

		return -1;
	}

}
