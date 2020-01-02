package Arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LargestNumber {

	// DO NOT MODIFY THE LIST. IT IS READ ONLY
	public static String largestNumber(final List<Integer> A) {

		ArrayList<Integer> arr = new ArrayList<Integer>(A);
		Collections.sort(arr, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				String s1 = String.valueOf(o1) + String.valueOf(o2);
				String s2 = String.valueOf(o2) + String.valueOf(o1);

				return Long.compare(Long.valueOf(s2), Long.valueOf(s1));
			}
		});

		StringBuilder sb = new StringBuilder();

		if (arr.get(0) == 0) {
			return 0 + "";
		}

		for (int i : arr) {
			sb.append(i);
		}

		return sb.toString();
	}

	public static void main(String[] args) {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		arr.add(8);
		arr.add(89);
		System.out.println(largestNumber(arr));
	}

}
