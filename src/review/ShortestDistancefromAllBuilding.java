package review;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestDistancefromAllBuilding {
	private static final int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};
	public int shortestDistance(int[][] grid) {
		if (grid == null || grid.length == 0) {
			return 0;
		}
		int m = grid.length;
		int n = grid[0].length;
		//distance[i][j] (i,j)is empty land the
		//sum of shortest distance to all buildings
		int[][] distance = new int[m][n];
		int[][] reach = new int[m][n];
		int numBuilding = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 1) {
					numBuilding ++;
					Queue<int[]> Q = new LinkedList<>();
					Q.offer(new int[]{i,j});
					boolean[][] visited = new boolean[m][n];
					//current distance
					int level = 1;
					while (!Q.isEmpty()) {
						//什么时候需要size什么时候不要到底？
						int size = Q.size();
						for (int k = 0; k < size; k++) {
							int[] cur = Q.poll();
							for (int[] dir : dirs) {
								int row = cur[0] + dir[0];
								int col = cur[1] + dir[1];
								if (row < 0 || col < 0 || row >= m || col >= n
										||visited[row][col] ||grid[row][col] != 0) {
									continue;
								}
								distance[row][col] += level;
								reach[row][col]  ++;
								visited[row][col] = true;
								Q.offer(new int[]{row,col});
							}
						}
						level ++;
					}
				}
			}
		}
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 0 && reach[i][j] == numBuilding) {
					min = Math.min(min, distance[i][j]);
				}
			}
		}
		return min == Integer.MAX_VALUE ? -1 : min;
	}
}
