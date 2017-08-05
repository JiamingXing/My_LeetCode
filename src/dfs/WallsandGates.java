package dfs;

import java.util.LinkedList;
import java.util.Queue;

public class WallsandGates {
	public void wallsAndGates(int[][] rooms) {
		if (rooms.length == 0) {
			return;
		}
		Queue<int[]> Q = new LinkedList<>();
		int m = rooms.length;
		int n = rooms[0].length;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (rooms[i][j] == 0) {
					Q.add(new int[]{i, j});
				}
			}
		}
		while (!Q.isEmpty()) {
			int[] cur = Q.poll();
			int row = cur[0];
			int col = cur[1];
			if (row > 0 && rooms[row-1][col] == Integer.MAX_VALUE) {
				rooms[row-1][col] = rooms[row][col] + 1;
				Q.add(new int[]{row-1, col});
			}
			if (row < m-1 && rooms[row+1][col] == Integer.MAX_VALUE) {
				rooms[row+1][col] = rooms[row][col] + 1;
				Q.add(new int[]{row+1, col});
			}
			if (col > 0 && rooms[row][col-1] == Integer.MAX_VALUE) {
				rooms[row][col-1] = rooms[row][col] + 1;
				Q.add(new int[]{row, col-1});
			}
			if (col < n-1 && rooms[row][col+1] == Integer.MAX_VALUE) {
				rooms[row][col+1] = rooms[row][col] + 1;
				Q.add(new int[]{row, col+1});
			}
		}
	}
}
