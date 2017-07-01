package array;
// follow up : could you solve in place?
public class GameOfLife {
	public void gameOfLife(int[][] board) {
		int m = board.length;
		int n = board[0].length;
		int[][] res = new int[board.length][board[0].length];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				int temp = count(board, m, n, i, j);
				if (board[i][j] == 1) {
					if (temp == 2 || temp == 3) {
						res[i][j] = 1;
					} else {
						res[i][j] = 0;
					}
				} else {
					if (temp ==3) {
						res[i][j] = 1;
					} else {
						res[i][j] = 0;
					}
				}	
			}
		}
	}
	public int count(int[][] board, int m, int n, int i, int j) {
		int res = 0;
		for (int x = i-1; x <= i+1; x ++) {
			for (int y = j-1; y <= j+1; j++) {
				if (x < 0 || x > m-1 || y < 0 || y > n-1 || x == y) {
					continue;
				} else {
					res += board[x][y];
				}
			}
		}
		return res;
	}
}
