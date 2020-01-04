package Array;

public class RemoveDup {

	public static int remove(int[] arr) {
		int nextDuplicate = 0;

		for (int i = 1; i < arr.length; i++) {
			if (arr[i] == arr[i - 1]) {
				arr[nextDuplicate] = arr[i];
			} else {
				arr[++nextDuplicate] = arr[i];
			}
		}
		return nextDuplicate + 1;
	}

	public static void main(String[] args) {
		int[] arr = { 2, 3, 3, 3, 6, 6, 9, 9 };
		printArr(arr);
		remove(arr);
		printArr(arr);

	}

	static void printArr(int[] arr) {
		for (int i : arr) {
			System.out.print(i + " ");
		}

		System.out.println();
	}
}
