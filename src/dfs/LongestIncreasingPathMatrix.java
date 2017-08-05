package dfs;

public class LongestIncreasingPathMatrix {
	public static final int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}};
	public int longestIncreasingPath(int[][] matrix) {
		int m = matrix.length;
		int n = matrix[0].length;
		if (matrix == null || m == 0) {
			return 0;
		}
		//记录从(i,j)这个位置出发最长的长度
		int[][] count = new int[m][n];
		int max = 1;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				int len = helper(matrix, count, i, j);
				max = Math.max(max, len);
			}
		}
		return max;
	}
	private int helper(int[][] matrix, int[][] count, int i, int j) {
		if (count[i][j] != 0) {
			return count[i][j];
		}
		int max = 1;
		for (int[] dir : dirs) {
			int row = dir[0] + i;
			int col = dir[1] + j;
			if (row < 0 || col < 0 || row >= matrix.length || col >= matrix[0].length || matrix[row][col] <= matrix[i][j]) {
				continue;
			}
			int len = 1 + helper(matrix, count, row, col);
			max = Math.max(max, len);
		}
		count[i][j] = max;
		return max;
	}
}
