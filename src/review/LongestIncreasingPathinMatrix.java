package review;

public class LongestIncreasingPathinMatrix {
	private static final int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
	public int longestIncreasingPath(int[][] matrix) {
		if (matrix == null || matrix.length == 0) {
			return 0;
		}
		int m = matrix.length;
		int n = matrix[0].length;
		int[][] visited = new int[m][n];
		int max = 1;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				int len = dfs(matrix, visited, i, j);
				max = Math.max(max, len);
			}
		}
		return max;
	}
	private int dfs(int[][] matrix, int[][] visited, int i, int j) {
		if (visited[i][j] != 0) {
			return visited[i][j];
		}
		int max = 1;
		for (int[] dir : dirs) {
			int row = i + dir[0];
			int col = j + dir[1];
			if (row < 0 || col < 0 || row >= matrix.length 
					|| col >= matrix[0].length || matrix[row][col] <= matrix[i][j]) {
				continue;
			}
			int len = 1 + dfs(matrix, visited, row, col);
			max = Math.max(max, len);
		}
		visited[i][j] = max;
		return max;
	}
}
