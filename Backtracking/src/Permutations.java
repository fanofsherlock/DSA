

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Permutations {

	static List<List<Integer>> result = new ArrayList<>();;

	public static List<List<Integer>> permute(List<Integer> A) {
		permuteUtil(A, 0, A.size());
		return result;
	}

	static void permuteUtil(List<Integer> A, int l, int r) {

		if (l == r) {
			result.add(new ArrayList(A));
		}

		for (int i = l; i < r; i++) {
			swap(A, l, i);
			permuteUtil(A, l + 1, r);
			swap(A, l, i);
		}
	}

	static void swap(List<Integer> A, int l, int r) {
		int temp = A.get(l);
		A.set(l, A.get(r));
		A.set(r, temp);
	}

	public static void main(String[] args) {
		List<Integer> list = Stream.iterate(1, i -> i + 1).limit(3).collect(Collectors.toList());

		List<List<Integer>> lists = permute(list);
		for (int i = 0; i < lists.size(); i++) {
			for (Integer k : lists.get(i)) {
				System.out.print(k + " ");
			}
			System.out.println();
		}
	}
}
