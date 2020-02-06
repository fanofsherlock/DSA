package Arrays;

public class MedianInSortedArrays {

	public static double findMedianSortedArrays(int[] ar1, int[] ar2) {
		if (ar1 == null || ar1.length == 0) {
			return calculateMedianOfSingleArray(ar2);
		}

		if (ar2 == null || ar2.length == 0) {
			return calculateMedianOfSingleArray(ar1);
		}

		int m = ar1.length, n = ar2.length;
		int count = 0;
		int i = 0, j = 0;
		double m1 = 0;

		// if the total number of elements is odd then the
		// median will simply be the (m+n)th element
		// Hence we will be finding the (m+n)th/2 smallest element out
		// of the two elements

		if ((m + n) % 2 == 1) {
			for (count = 0; count <= (m + n) / 2; count++) {
				if (i != m && j != n) {
					m1 = (ar1[i] > ar2[j]) ? ar2[j++] : ar1[i++];
				} else if (i != m) {
					m1 = ar1[i++];
				} else if (j != n) {
					m1 = ar2[j++];
				}
			}
		}

		// in case m+n is even then we need to find the average
		// of (m+n)/2 -1 and (m+n)/2th element

		else {
			double m2 = 0;
			for (count = 0; count <= (m + n) / 2; count++) {
				// Hence m2 will always be the secondlast value m1 takes
				// Since m1 last value will be (m+n)/2 hence m2 will represent a value just
				// beneath that
				m2 = m1;
				if (i != m && j != n) {
					m1 = (ar1[i] > ar2[j]) ? ar2[j++] : ar1[i++];
				}

				else if (i != m) {
					m1 = ar1[i++];
				} else if (j != n) {
					m1 = ar2[j++];
				}
			}

			m1 = (m2 + m1) / 2;

		}

		return m1;

	}

	static double calculateMedianOfSingleArray(int[] a) {
		if (a.length % 2 == 1) {
			return a[(a.length / 2)];
		} else {
			return ((double) a[(a.length / 2)] + (double) a[((a.length / 2) - 1)]) / 2;
		}
	}

	public static void main(String[] args) {
		int ar1[] = { 3 };
		int ar2[] = { -2,-1 };
		System.out.println(findMedianSortedArrays(ar1, ar2));

	}
}
