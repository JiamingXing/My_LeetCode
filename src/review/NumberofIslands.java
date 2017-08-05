package review;


public class NumberofIslands {
	private static final int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};
	public int numIslands(char[][] grid) {
		if (grid == null || grid.length == 0) {
			return 0;
		}
		int m = grid.length;
		int n = grid[0].length;
		boolean[][] visited = new boolean[m][n];
		int res = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (visited[i][j]) {
					continue;
				}
				if (grid[i][j] == '1') {
					helper(grid, visited, i, j);
					res ++;
				}
			}
		}
		return res;
	}
	private void helper(char[][] grid, boolean[][] visited, int i, int j) {
		if (i < 0 || j < 0 || i >= grid.length 
				|| j >= grid[0].length || visited[i][j] || grid[i][j] == '0') {
			return;
		}
		visited[i][j] = true;
		for (int[] dir : dirs) {
			int row = i + dir[0];
			int col = j + dir[1];
			helper(grid, visited, row, col);
		}
	}
}
