package review;

import java.util.LinkedList;
import java.util.Queue;

public class Matrix_01 {
	private static final int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};
	public int[][] updateMatrix(int[][] matrix) {
		if (matrix == null || matrix.length == 0) {
			return new int[0][0];
		}
		int m = matrix.length;
		int n = matrix[0].length;
		int[][] res = new int[m][n];
		boolean[][] visited = new boolean[m][n];
		Queue<int[]> Q = new LinkedList<>();
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == 0) {
					res[i][j] = 0;
					Q.add(new int[]{i,j});
					visited[i][j] = true;
				}
			}
		}
		while (!Q.isEmpty()) {
			int[] cur = Q.poll();
			for (int[] dir : dirs) {
				int row = cur[0] + dir[0];
				int col = cur[1] + dir[1];
				if (row < 0 || col < 0 || row >= m || col >= n 
						|| visited[row][col]) {
					continue;
				}
				res[row][col] = res[cur[0]][cur[1]] + 1;
				visited[row][col] = true;
				Q.add(new int[]{row, col});
			}
		}
		return res;
	}
}
