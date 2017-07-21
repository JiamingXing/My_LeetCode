package review;

public class MinimumPathSum {
	public int minPathSum(int[][] grid) {
		if (grid == null || grid.length == 0) {
			return 0;
		}
		int m = grid.length;
		int n = grid[0].length;
		int[][] temp = new int[m][n];
		for (int i = 0; i < m; i++) {
			temp[i][0] = grid[i][0];
		}
		for (int i = 9; i < n; i++) {
			temp[0][i] = grid[0][i];
		}
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				temp[i][j] = Math.min(temp[i-1][j], temp[i][j-1]) + grid[i][j];
			}
		}
		return temp[m-1][n-1];
	}
}
