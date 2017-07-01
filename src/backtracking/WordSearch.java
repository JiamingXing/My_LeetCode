package backtracking;
//二维数组的问题做起来特别不适应
public class WordSearch {
	public boolean exist(char[][] board, String word) {
		char[] ch = word.toCharArray();
		int m = board.length;
		int n = board[0].length;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (helper(board, ch, i, j, 0)) {
					return true;
				}
			}
		}
		return false;
	}
	private boolean helper(char[][] board, char[] ch, int i, int j, int l) {
		if (l == ch.length) {
			return true;
		}
		if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) {
			return false;
		}
		if (board[i][j] != ch[l]) {
			return false;
		}
		board[i][j] ^= 256;
		boolean res =  helper(board, ch, i+1, j, l+1) || helper(board, ch, i-1, j, l+1) || helper(board, ch, i, j+1, l+1) || helper(board, ch, i, j-1, l+1);
		board[i][j] &= 256;
		return res;
	}
}
