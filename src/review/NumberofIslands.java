package review;


public class NumberofIslands {
	private static final int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};
	public int numIslands(char[][] grid) {
		if (grid == null || grid.length == 0) {
			return 0;
		}
		int m = grid.length;
		int n = grid[0].length;
		boolean[][] visited = new boolean[m][n];
		int res = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (visited[i][j]) {
					continue;
				}
				if (grid[i][j] == '1') {
					helper(grid, visited, i, j);
					res ++;
				}
			}
		}
		return res;
	}
	private void helper(char[][] grid, boolean[][] visited, int i, int j) {
		if (i < 0 || j < 0 || i >= grid.length 
				|| j >= grid[0].length || visited[i][j] || grid[i][j] == '0') {
			return;
		}
		visited[i][j] = true;
		for (int[] dir : dirs) {
			int row = i + dir[0];
			int col = j + dir[1];
			helper(grid, visited, row, col);
		}
	}
}


//BFS 但是用[] dir会超时 试试用hard code？
/*
public class Solution {
    private static final int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
			return 0;
		}
		int m = grid.length;
		int n = grid[0].length;
		boolean[][] visited = new boolean[m][n];
		int res = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (visited[i][j]) {
					continue;
				}
				if (grid[i][j] == '1') {
                    Queue<int[]> Q = new LinkedList<>();
                    Q.add(new int[]{i, j});
					helper(grid, visited, Q);
					res ++;
				}
			}
		}
		return res;
    }
    private void helper(char[][] grid, boolean[][] visited, Queue<int[]> Q) {
        while (!Q.isEmpty()) {
            int size = Q.size();
            for (int i = 0; i < size; i++) {
                int[] cur = Q.poll();
                visited[cur[0]][cur[1]] = true;
                //hard code
//                int row = cur[0];
//                int col = cur[1];
//                if (row + 1 < grid.length && !visited[row+1][col] && grid[row+1][col] == '1') {
//                    Q.add(new int[]{row+1, col});
//                }
//                if (row - 1 >= 0 && !visited[row-1][col] && grid[row-1][col] == '1') {
//                    Q.add(new int[]{row-1, col});
//                }
//                if (col + 1 < grid[0].length && !visited[row][col+1] && grid[row][col+1] == '1') {
//                    Q.add(new int[]{row, col+1});
//                }
//                if (col - 1 >= 0 && !visited[row][col-1] && grid[row][col-1] == '1') {
//                    Q.add(new int[]{row, col-1});
//                }
                for (int[] dir : dirs) {
                    int row = cur[0] + dir[0];
                    int col = cur[1] + dir[1];
                    if (row >= 0 && col >= 0 && row < grid.length && col < grid[0].length 
                        && !visited[row][col] && grid[row][col] == '1') {
                        Q.add(new int[]{row, col});
                    }
                }
            }
        }
	}
}
*/
