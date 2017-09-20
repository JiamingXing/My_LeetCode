package backtracking;

public class SudokuSolver {
	public void solveSudoku(char[][] board) {
		if (board == null || board.length == 0) {
			return;
		}
		helper(board);
	}
	private boolean helper(char[][] board) {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (board[i][j] == '.') {
					for (char c = '1'; c <= '9'; c++) {
						if (isValid(board, i, j, c)) {
							board[i][j] = c;
							if (helper(board)) {
								return true;
							} else {
								board[i][j] = '.';
							}
						}
					}
					return false;
				}
			}
		}
		return true;
		//一开始觉得是return false 为什么应该是true？
//		return false;
	}
	private boolean isValid(char[][] board, int i, int j, char c) {
		for (int k = 0; k < 9; k++) {
			if (board[i][k] != '.' && board[i][k] == c) {
				return false;
			}
			if (board[k][j] != '.' && board[k][j] == c) {
				return false;
			}
			int row = 3 * (i/3) + k/3;
			int col = 3 * (j/3) + k%3;
			if (board[row][col] != '.' && board[row][col] == c) {
				return false;
			}
		}
		return true;
	}
}
