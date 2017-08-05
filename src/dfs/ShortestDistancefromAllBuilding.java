package dfs;

import java.util.LinkedList;
import java.util.Queue;
//比较慢的方法
public class ShortestDistancefromAllBuilding {
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
							int row = cur[0];
							int col = cur[1];
							//四个方向这段代码是可以缩减的
							if (row > 0 && !visited[row-1][col] && grid[row-1][col] == 0) {
								distance[row-1][col] += level;
								reach[row-1][col] ++;
								visited[row-1][col] = true;
								Q.offer(new int[]{row-1, col});
							}
							if (row < m-1 && !visited[row+1][col] && grid[row+1][col] == 0) {
								distance[row+1][col] += level;
								reach[row+1][col] ++;
								visited[row+1][col] = true;
								Q.offer(new int[]{row+1, col});
							}
							if (col > 0 && !visited[row][col-1] && grid[row][col-1] == 0) {
								distance[row][col-1] += level;
								reach[row][col-1] ++;
								visited[row][col-1] = true;
								Q.offer(new int[]{row, col-1});
							}
							if (col < n-1 && !visited[row][col+1] && grid[row][col+1] == 0) {
								distance[row][col+1] += level;
								reach[row][col+1] ++;
								visited[row][col+1] = true;
								Q.offer(new int[]{row, col+1});
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
