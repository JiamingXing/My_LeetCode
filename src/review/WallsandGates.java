package review;

import java.util.LinkedList;
import java.util.Queue;

public class WallsandGates {
	private static final int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};
	public void wallsAndGates(int[][] rooms) {
		if (rooms.length == 0) {
			return;
		}
        Queue<int[]> Q = new LinkedList<>();
		int m = rooms.length;
		int n = rooms[0].length;
		boolean[][] visited = new boolean[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (rooms[i][j] == 0) {
					Q.add(new int[]{i, j});
				}
			}
		}
		while (!Q.isEmpty()) {
			int[] cur = Q.poll();
			for (int[] dir : dirs) {
				int row = cur[0] + dir[0];
				int col = cur[1] + dir[1];
				if (row < 0 || col < 0 || row >= m || col >= n
						|| visited[row][col] || rooms[row][col] != Integer.MAX_VALUE) {
					continue;
				}
				rooms[row][col] = rooms[cur[0]][cur[1]] + 1;
				visited[row][col] = true;
				Q.offer(new int[]{row,col});
			}
		}
	}
}
