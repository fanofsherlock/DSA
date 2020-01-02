package Hashing;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class HashColorFulNumber {
	static HashSet<Integer> mul = new HashSet<>();
	static ArrayList<Integer> list = new ArrayList<>();

	public static void main(String[] args) {
		System.out.println(colorful(9));
	}

	public static int colorful(int A) {

		fillList(A);

		for (int i = 0; i < list.size(); i++) {

			int multiples = list.get(i);

			if (!mul.contains(multiples)) {
				mul.add(multiples);
			}

			else {
				return 0;
			}

			for (int j = i + 1; j < list.size(); j++) {
				multiples = multiples * list.get(j);
				if (!mul.contains(multiples)) {
					mul.add(multiples);
				}

				else {
					return 0;
				}
			}
		}

		return 1;
	}

	public static void fillList(int cal) {

		while (cal > 0) {
			list.add(cal % 10);
			cal = cal / 10;
		}

		Collections.reverse(list);
	}



}
