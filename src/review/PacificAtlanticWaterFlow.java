package review;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PacificAtlanticWaterFlow {
	private static final int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};
	public List<int[]> pacificAtlantic(int[][] matrix) {
		List<int[]> res = new ArrayList<>();
		if (matrix == null || matrix.length == 0) {
			return res;
		}
		int m = matrix.length;
		int n = matrix[0].length;
		Queue<int[]> QP = new LinkedList<>();
		Queue<int[]> QA = new LinkedList<>();
		boolean[][] visitedP = new boolean[m][n];
		boolean[][] visitedA = new boolean[m][n];
		for (int i = 0; i < m; i++) {
			QP.offer(new int[]{i,0});
			QA.offer(new int[]{i,n-1});
			visitedP[i][0] = true;
			visitedA[i][n-1] = true;
		}
		for (int i = 0; i < n; i++) {
			QP.offer(new int[]{0,i});
			QA.offer(new int[]{m-1,i});
			visitedP[0][i] = true;
			visitedA[m-1][i] = true;
		}
		helper(matrix, visitedP, QP);
		helper(matrix, visitedA, QA);
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (visitedA[i][j] && visitedP[i][j]) {
					res.add(new int[]{i,j});
				}
			}
		}
		return res;
	}
	private void helper(int[][] matrix, boolean[][] visited, Queue<int[]> Q) {
		int m = matrix.length;
		int n = matrix[0].length;
		while (!Q.isEmpty()) {
			int[] cur = Q.poll();
			for (int[] dir : dirs) {
				int row = cur[0] + dir[0];
				int col = cur[1] + dir[1];
				if (row < 0 || col < 0 || row >= m || col >= n
						|| visited[row][col] ||matrix[row][col] < matrix[cur[0]][cur[1]]) {
					continue;
				}
				Q.offer(new int[]{row,col});
				visited[row][col] = true;
			}
		}
	}
}
