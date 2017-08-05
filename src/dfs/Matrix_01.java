package dfs;

import java.util.LinkedList;
import java.util.Queue;
//代码可能写的不够简洁
public class Matrix_01 {
	public int[][] updateMatrix(int[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
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
					visited[i][j] = true;
					Q.add(new int[]{i,j});
				}
			}
		}
		while (!Q.isEmpty()) {
			int[] cur = Q.poll();
			int row = cur[0];
			int col = cur[1];
			if (row > 0 && !visited[row-1][col] && matrix[row-1][col] != 0) {
				res[row-1][col] = res[row][col] + 1;
				visited[row-1][col] = true;
				Q.add(new int[]{row-1, col});
			}
			if (row < m-1 && !visited[row+1][col] && matrix[row+1][col] != 0) {
				res[row+1][col] = res[row][col] + 1;
				visited[row+1][col] = true;
				Q.add(new int[]{row+1, col});
			}
			if (col > 0 && !visited[row][col-1] && matrix[row][col-1] != 0) {
				res[row][col-1] = res[row][col] +1;
				visited[row][col-1] = true;
				Q.add(new int[]{row, col-1});
			}
			if (col < n-1 && !visited[row][col+1] && matrix[row][col+1] != 0) {
				res[row][col+1] = res[row][col] + 1;
				visited[row][col+1] = true;
				Q.add(new int[]{row, col+1});
			}
		}
		return res;
	}
}
