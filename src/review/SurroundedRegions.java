package review;
// stack over flow error
//DFS
public class SurroundedRegions {
	private static final int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
	public void solve(char[][] board) {
		if (board.length == 0 || board.length <= 2 || board[0].length <= 2) {
            return;
        }
        int m = board.length;
        int n = board[0].length;
        boolean visited[][] = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') {
                helper(board, visited, i, 0);
            }
            if (board[i][n-1] == 'O') {
                helper(board, visited, i, n-1);
            }
        }
        for (int i = 0; i < n; i++) {
            if (board[0][i] == 'O') {
                helper(board, visited, 0, i);
            }
            if (board[m-1][i] == 'O') {
                helper(board, visited, m-1, i);
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O' && !visited[i][j]) {
                    board[i][j] = 'X';
                } 
            }
        }
	}
	private void helper(char[][] board, boolean[][] visited, int i, int j) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] == 'X' || visited[i][j]) {
            return;
        }
        if (board[i][j] == 'O') {
            visited[i][j] = true;
        }
        for (int[] dir : dirs) {
            int row = i + dir[0];
            int col = j + dir[1];
            helper(board, visited, row, col);
        }
    }
}


//BFS
/*
class Solution {
    private static final int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
    public void solve(char[][] board) {
        if (board.length == 0 || board.length <= 2 || board[0].length <= 2) {
            return;
        }
        int m = board.length;
        int n = board[0].length;
        boolean visited[][] = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O' && !visited[i][0]) {
                helper(board, visited, i, 0);
            }
            if (board[i][n-1] == 'O' && !visited[i][n-1]) {
                helper(board, visited, i, n-1);
            }
        }
        for (int i = 0; i < n; i++) {
            if (board[0][i] == 'O' && !visited[0][i]) {
                helper(board, visited, 0, i);
            }
            if (board[m-1][i] == 'O' && !visited[m-1][i]) {
                helper(board, visited, m-1, i);
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O' && !visited[i][j]) {
                    board[i][j] = 'X';
                } 
            }
        }
    }
    private void helper(char[][] board, boolean[][] visited, int i, int j) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] == 'X' || visited[i][j]) {
            return;
        }
        if (board[i][j] == 'O') {
            visited[i][j] = true;
        }
        Queue<int[]> Q = new LinkedList<>();
        Q.add(new int[]{i, j});
        visited[i][j] = true;
        while (!Q.isEmpty()) {
            int[] cur = Q.poll();
            for (int[] dir : dirs) {
                int row = dir[0] + cur[0];
                int col = dir[1] + cur[1];
                if (row < 0 || col < 0 || row >= board.length 
                    || col >= board[0].length || board[row][col] == 'X' || visited[row][col]) {
                    continue;
                }
                Q.add(new int[]{row, col});
                visited[row][col] = true;
            }
        }
    }
}
*/


/*
public class SurroundedRegions {
	public void solve(char[][] board) {
		if (board.length == 0 || board[0].length == 0) {
			return;
		}
		if (board.length <= 2 || board[0].length <= 2) {
			return;
		}
		int m = board.length;
		int n = board[0].length;
		for (int i = 0; i < m; i++) {
			if (board[i][0] == 'O') {
				helper(board, i, 0);
			}
			if (board[i][n-1] == 'O') {
				helper(board, i, n-1);
			}
		}
		for (int i = 0; i < n; i++) {
			if (board[0][i] == 'O') {
				helper(board, 0, i);
			}
			if (board[m-1][i] == 'O') {
				helper(board, m-1, i);
			}
		}
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (board[i][j] == 'O') {
					board[i][j] = 'X';
				} else if (board[i][j] == '*') {
					board[i][j] = 'O';
				}
			}
		}
	}
	private void helper(char[][] board, int i, int j) {
		if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) {
			return;
		}
		if (board[i][j] == 'O') {
			board[i][j] = '*';
		}
		if (i > 1 && board[i-1][j] == 'O') {
			helper(board, i-1, j);
		}
		if (i < board.length-2 && board[i+1][j] == 'O') {
			helper(board, i+1, j);
		}
		if (j > 1 && board[i][j-1] == 'O') {
			helper(board, i, j-1);
		}
		if (j < board[0].length-2 && board[i][j+1] == 'O') {
			helper(board, i, j+1);
		}
	}
}
*/
