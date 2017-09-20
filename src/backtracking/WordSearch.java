package backtracking;
//这是我比较习惯写起来的DFS递归方式
public class WordSearch {
	private static final int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
	public boolean exist(char[][] board, String word) {
		int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (helper(board, visited, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
	}
	private boolean helper(char[][] board, boolean[][] visited, String word, int i, int j, int pos) {
        if (pos == word.length()) {
            return true;
        }
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || visited[i][j] || board[i][j] != word.charAt(pos)) {
            return false;
        }
        visited[i][j] = true;
        boolean res = false;
        for (int[] dir : dirs) {
            int row = i + dir[0];
            int col = j + dir[1];
            res = res || helper(board, visited, word, row, col, pos + 1);
        }
        visited[i][j] = false;
        return res;
    }
}
