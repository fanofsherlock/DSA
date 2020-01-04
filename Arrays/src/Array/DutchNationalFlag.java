package Array;

public class DutchNationalFlag {

	public static void sort(int[] arr) {
		int i=0,low = 0, high = arr.length - 1;
		
		while(i<=high) {
			
			if (arr[i] == 1) {
				i++;
			} 
		    else if (arr[i] == 0) {
				swap(arr, i, low);
				i++;
				low++;
			} 
			else { 
				swap(arr, i, high);
				high--;
			}
		}
	}

	private static void swap(int[] arr, int i, int j) {
	    arr[i]=arr[i]+arr[j];
		arr[j] =arr[i]-arr[j];
		arr[i] =arr[i]-arr[j];
	}

	public static void main(String[] args) {
		int[] arr = new int[] { 1, 0, 2, 1, 0 };
		DutchNationalFlag.sort(arr);
		for (int num : arr)
			System.out.print(num + " ");
		System.out.println();

		arr = new int[] { 2, 2, 0, 1, 2, 0 };
		DutchNationalFlag.sort(arr);
		for (int num : arr)
			System.out.print(num + " ");
	}
}
