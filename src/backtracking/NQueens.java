package backtracking;

import java.util.ArrayList;
import java.util.List;

public class NQueens {
	public List<List<String>> solveNQueens(int n) {
		List<List<String>> res = new ArrayList<>();
		char[][] board = new char[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				board[i][j] = '.';
			}
		}
		helper(board, res, 0);
		return res;
	}
	public void helper(char[][] board, List<List<String>> res, int start) {
		if (start == board.length) {
			res.add(transfer(board));
			return;
		}
		for (int i = 0; i < board[start].length; i++) {
			if (validate(board, start, i)) {
				board[start][i] = 'Q';
				helper(board, res, start+1);
				board[start][i] = '.';
			}
		}
	}
	public boolean validate(char[][] board, int row, int col) {
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < board[row].length; j++) {
				if (board[i][j] == 'Q' && (row + j == col + i || col == j || row + col == i + j)) {
					return false;
				}
			}
		}
		return true;
	}
	public List<String> transfer(char[][] board) {
		List<String> res = new ArrayList<>();
		for (int i = 0; i < board.length; i++) {
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < board[i].length; j++) {
				sb.append(board[i][j]);
			}
			res.add(sb.toString());
		}
		return res;
	}
}
