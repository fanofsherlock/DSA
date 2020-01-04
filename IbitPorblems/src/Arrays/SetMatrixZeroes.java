package Arrays;

import java.util.ArrayList;

public class SetMatrixZeroes {

	public void setZeroes1(ArrayList<ArrayList<Integer>> a) {
		boolean[] columns = new boolean[a.get(0).size()];

		for (int i = 0; i < a.size(); i++) {
			for (int j = 0; j < a.get(i).size(); j++) {

				if (a.get(i).get(j) == 0) {
					columns[j] = true;
					for (int k = 0; k < a.get(i).size(); k++) {
						a.get(i).set(k, 0);
					}
					break;
				}

				if (columns[j]) {
					a.get(i).set(j, 0);
				}
			}
		}
	}

	public static void setZeroes2(ArrayList<ArrayList<Integer>> a) {

		ArrayList<ArrayList<Integer>> b = new ArrayList<ArrayList<Integer>>();

		for (int i = 0; i < a.size(); i++) {
			b.add((ArrayList<Integer>) a.get(i).clone());
			for (int j = 0; j < a.get(i).size(); j++) {
				a.get(i).set(j, 1);
			}
		}

		boolean[] columns = new boolean[a.get(0).size()];
		boolean[] rows = new boolean[a.size()];

		for (int i = 0; i < b.size(); i++) {
			for (int j = 0; j < b.get(i).size(); j++) {

				if (columns[j]) {
					a.get(i).set(j, 0);
				}

				if (rows[i]) {
					a.get(i).set(j, 0);
				}

				if (b.get(i).get(j) == 0) {
					setColumnZero(a, j, columns);
					rows[i] = true;
				}

			}

			if (rows[i]) {
				for (int j = 0; j < b.get(i).size(); j++) {
					a.get(i).set(j, 0);
				}
			}

		}
	}

	static void setColumnZero(ArrayList<ArrayList<Integer>> b, int k, boolean[] columns) {

		if (columns[k]) {
			return;
		}

		for (int i = 0; i < b.size(); i++) {
			b.get(i).set(k, 0);
		}

		columns[k] = true;

	}

	public static void setZeroes3(ArrayList<ArrayList<Integer>> a) {
		int r1 = 1, c1 = 1;

		// Step1: Checking if row1 and Col1 initially had any zero values
		for (int i = 0; i < a.get(0).size(); i++) {
			if (a.get(0).get(i) == 0) {
				r1 = 0;
				break;
			}
		}

		for (int i = 0; i < a.size(); i++) {
			if (a.get(i).get(0) == 0) {
				c1 = 0;
				break;
			}
		}

		// Step2: Going through from row2..m and col1...n to mark the note
		// whether that column or row is supposed to be zero
		for (int i = 1; i < a.size(); i++) {
			for (int j = 1; j < a.get(i).size(); j++) {
				if (a.get(i).get(j) == 0) {
					a.get(i).set(0, 0);
					a.get(0).set(j, 0);

				}
			}
		}

		// Step3: Making changes in the matrix if the first row and first column is
		// zeroes
		for (int i = 1; i < a.size(); i++) {
			for (int j = 1; j < a.get(i).size(); j++) {
				if (a.get(i).get(0) == 0 || a.get(0).get(j) == 0) {
					a.get(i).set(j, 0);

				}
			}
		}

		// Step4: Marking the first row and first columns as zero
		// if they initially had any zero values
		for (int i = 0; i < a.get(0).size(); i++) {
			if (r1 == 0) {
				a.get(0).set(i, 0);

			}
		}

		for (int i = 0; i < a.size(); i++) {
			if (c1 == 0) {
				a.get(i).set(0, 0);
			}
		}

	}

	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> c = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> r1 = new ArrayList<Integer>();
		r1.add(0);
		r1.add(0);
		ArrayList<Integer> r2 = new ArrayList<Integer>();
		r2.add(1);
		r2.add(0);

		c.add(r1);
		c.add(r2);

		setZeroes2(c);
		for (ArrayList<Integer> q : c) {
			for (int i : q) {
				System.out.print(i + " ");
			}
			System.out.println();
		}

	}

}
