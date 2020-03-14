package Median;

import java.util.List;

public class MedianSortedArrays2 {

	public static double findMedianSortedArrays(final List<Integer> a, final List<Integer> b) {
		int len = a.size() + b.size();
		if (len % 2 == 1) {
			return findKthSmallest(a, 0, b, 0, len / 2 + 1);
		}
		return (findKthSmallest(a, 0, b, 0, len / 2) + findKthSmallest(a, 0, b, 0, len / 2 + 1)) / 2.0;
	}

	public static int findKthSmallest(final List<Integer> a, int aStart, final List<Integer> b, int bStart, int k) {
		if (aStart >= a.size()) {
			return b.get(bStart + k - 1);
		}
		if (bStart >= b.size()) {
			return a.get(aStart + k - 1);
		}
		if (k == 1) {
			return Math.min(a.get(aStart), b.get(bStart));
		}
		int aKey = 0;
		int bKey = 0;
		if (aStart + k / 2 - 1 < a.size()) {
			aKey = a.get(aStart + k / 2 - 1);
		} else
			aKey = Integer.MAX_VALUE;
		if (bStart + k / 2 - 1 < b.size()) {
			bKey = b.get(bStart + k / 2 - 1);
		} else
			bKey = Integer.MAX_VALUE;

		if (aKey < bKey) {
			return findKthSmallest(a, aStart + k / 2, b, bStart, k - k / 2);
		} else {
			return findKthSmallest(a, aStart, b, bStart + k / 2, k - k / 2);
		}
	}

}
