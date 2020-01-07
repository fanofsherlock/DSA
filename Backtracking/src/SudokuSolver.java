
public class SudokuSolver {

	public void solveSudoku(char[][] board) {
		char[] c = new char[] { '1', '2', '3', '4', '5', '6', '7', '8', '9' };
		sudoku_solver(board, 0, 0, c);
	}

	public boolean isValid(char[][] board, int r, int c, char num) {

		// check if number already exists in that row
		for (int i = 0; i < board[r].length; i++) {
			if (board[r][i] == num) {
				return false;
			}
		}

		// check if number already exists in that column
		for (int i = 0; i < board.length; i++) {
			if (board[i][c] == num) {
				return false;
			}
		}

		// check if that number exists in that box
		int x = (r / 3) * 3;
		int y = (c / 3) * 3;

		for (int i = x; i < x + 3; i++) {
			for (int j = y; j < y + 3; j++) {
				if (board[i][j] == num) {
					return false;
				}
			}
		}

		return true;

	}

	public boolean sudoku_solver(char[][] board, int r, int c, char[] chars) {
		// specify goals
		if (c > 8) {
			c = 0;
			r++;
		}

		if (r == 9) {
			return true;
		}

		// make choices
		if (board[r][c] != '.') {
			return sudoku_solver(board, r, c + 1, chars);
		}
		// explore choices
		for (char ch : chars) {
			// Constraints
			if (isValid(board, r, c, ch)) {
				board[r][c] = ch;
				// if choice meets goal
				if (sudoku_solver(board, r, c + 1, chars)) {
					return true;
				}
				// otherwise undo choice
				board[r][c] = '.';
			}
		}
		return true;

	}

}
