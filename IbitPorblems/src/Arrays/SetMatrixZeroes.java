package Arrays;

import java.util.ArrayList;

public class SetMatrixZeroes {

	public void setZeroes(ArrayList<ArrayList<Integer>> a) {
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

	public void setZeroes2(ArrayList<ArrayList<Integer>> a) {
		boolean[] columns = new boolean[a.get(0).size()];
		boolean[] rows = new boolean[a.size()];

		for (int i = 0; i < a.size(); i++) {
			for (int j = 0; j < a.get(i).size(); j++) {

				if (columns[j]) {
					a.get(i).set(j, 0);
				}

				if (rows[i]) {
					a.get(i).set(j, 0);
				}

				if (a.get(i).get(j) == 0) {
					setColumnZero(a, j, columns);
					rows[i] = true;
				}

			}

			if (rows[i]) {
				for (int j = 0; j < a.get(i).size(); j++) {
					a.get(i).set(j, 0);
				}
			}

		}
	}

	void setColumnZero(ArrayList<ArrayList<Integer>> a, int k, boolean[] columns) {

		if (columns[k]) {
			return;
		}

		for (int i = 0; i < a.size(); i++) {
			a.get(i).set(k, 0);
		}

		columns[k] = true;

	}

}
