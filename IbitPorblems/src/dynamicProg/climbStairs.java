package dynamicProg;

public class climbStairs {

	public static int[] arr;

	public static void main(String[] args) {
		System.out.println();
	}

	public static int climbStairs(int a) {
		arr = new int[a + 1];
		if (a == 0)
			return 0;
		arr[0] = 0;
		if (a <= 1)
			return 1;
		arr[1] = 1;

		if (a <= 2)
			return 2;
		arr[2] = 2;
		return climb(a);

	}

	static int climb(int a) {
		if (arr[a] != 0)
			return arr[a];
		arr[a] = climb(a - 1) + climb(a - 2);
		return arr[a];
	}
}
