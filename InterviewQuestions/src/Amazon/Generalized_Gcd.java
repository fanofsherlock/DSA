package Amazon;

public class Generalized_Gcd {

	// METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
	public int generalizedGCD(int num, int[] arr) {
		if (num < 1 || arr == null || arr.length < 1) {
			return -1;
		}

		if (num == 1 || arr.length == 1) {
			return arr[0];
		}

		int gcd = gcd(arr[0], arr[1]);

		for (int i = 2; i < arr.length; i++) {
			gcd = gcd(gcd, arr[i]);
		}

		return gcd;

	}

	public int gcd(int a, int b) {
		if (b == 0) {
			return a;
		}

		return gcd(b, a % b);
	}

}
