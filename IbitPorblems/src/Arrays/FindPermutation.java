package Arrays;

import java.util.ArrayList;

public class FindPermutation {

	public static ArrayList<Integer> findPerm(final String A, int B) {
		ArrayList<Integer> a = new ArrayList<Integer>(B);

		for (int i = 0; i < B; i++) {
			a.add(i + 1);
		}

		for (int i = 0; i < A.length(); i++) {
			if (A.charAt(i) == 'D' && a.get(i) < a.get(i + 1)) {
				a.set(i, a.get(i) + a.get(i + 1));
				a.set(i + 1, a.get(i) - a.get(i + 1));
				a.set(i, a.get(i) - a.get(i + 1));
				continue;
				
			} else if (A.charAt(i) == 'I' && a.get(i) > a.get(i + 1)) {
				a.set(i, a.get(i) + a.get(i + 1));
				a.set(i + 1, a.get(i) - a.get(i + 1));
				a.set(i, a.get(i) - a.get(i + 1));
			}
		}

		return a;
	}

	public static void main(String[] args) {
		System.out.println(findPerm("DD", 3));
	}

}
