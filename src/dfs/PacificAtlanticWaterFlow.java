package dfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PacificAtlanticWaterFlow {
	public List<int[]> pacificAtlantic(int[][] matrix) {
		List<int[]> res = new ArrayList<>();
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return res;
		}
		int m = matrix.length;
		int n = matrix[0].length;
		Queue<int[]> QP = new LinkedList<>();
		Queue<int[]> QA = new LinkedList<>();
		boolean[][] pac = new boolean[m][n];
		boolean[][] atl = new boolean[m][n];
		for (int i = 0; i < m; i++) {
			pac[i][0] = true;
			atl[i][n-1] = true;
			QP.add(new int[]{i, 0});
			QA.add(new int[]{i, n-1});
		}
		for (int i = 0; i < n; i++) {
			pac[0][i] = true;
			atl[m-1][i] = true;
			QP.add(new int[]{0, i});
			QA.add(new int[]{m-1, i});
		}
		while (!QP.isEmpty()) {
			int[] cur = QP.poll();
			int row = cur[0];
			int col = cur[1];
			//bug
			if (row > 0 && !pac[row-1][col] && matrix[row-1][col] >= matrix[row][col]) {
				pac[row-1][col] = true;
				QP.add(new int[]{row-1, col});
			}
			if (row < m-1 && !pac[row+1][col] && matrix[row+1][col] >= matrix[row][col]) {
				pac[row+1][col] = true;
				QP.add(new int[]{row+11, col});
			}
			if (col > 0 && !pac[row][col-1] && matrix[row][col-1] >= matrix[row][col]) {
				pac[row][col-1] = true;
				QP.add(new int[]{row, col-1});
			}
			if (col < n-1 && !pac[row][col+1] && matrix[row][col+1] >= matrix[row][col]) {
				pac[row][col+1] = true;
				QP.add(new int[]{row, col+1});
			}
		}
		while (!QA.isEmpty()) {
			int[] cur = QA.poll();
			int row = cur[0];
			int col = cur[1];
			if (row > 0 && !atl[row-1][col] && matrix[row-1][col] >= matrix[row][col]) {
				atl[row-1][col] = true;
				QA.add(new int[]{row-1, col});
			}
			if (row < m-1 && !atl[row+1][col] && matrix[row+1][col] >= matrix[row][col]) {
				atl[row+1][col] = true;
				QA.add(new int[]{row+11, col});
			}
			if (col > 0 && !atl[row][col-1] && matrix[row][col-1] >= matrix[row][col]) {
				atl[row][col-1] = true;
				QA.add(new int[]{row, col-1});
			}
			if (col < n-1 && !atl[row][col+1] && matrix[row][col+1] >= matrix[row][col]) {
				atl[row][col+1] = true;
				QA.add(new int[]{row, col+1});
			}
		}
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (pac[i][j] && atl[i][j]) {
					res.add(new int[]{i, j});
				}
			}
		}
		return res;
	}
}

//写一个子函数 代码整体就简洁不少
/*
public class Solution {
    int[][]dir = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> res = new LinkedList<>();
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return res;
        }
        int n = matrix.length, m = matrix[0].length;
        //One visited map for each ocean
        boolean[][] pacific = new boolean[n][m];
        boolean[][] atlantic = new boolean[n][m];
        Queue<int[]> pQueue = new LinkedList<>();
        Queue<int[]> aQueue = new LinkedList<>();
        for(int i=0; i<n; i++){ //Vertical border
            pQueue.offer(new int[]{i, 0});
            aQueue.offer(new int[]{i, m-1});
            pacific[i][0] = true;
            atlantic[i][m-1] = true;
        }
        for(int i=0; i<m; i++){ //Horizontal border
            pQueue.offer(new int[]{0, i});
            aQueue.offer(new int[]{n-1, i});
            pacific[0][i] = true;
            atlantic[n-1][i] = true;
        }
        bfs(matrix, pQueue, pacific);
        bfs(matrix, aQueue, atlantic);
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(pacific[i][j] && atlantic[i][j])
                    res.add(new int[]{i,j});
            }
        }
        return res;
    }
    public void bfs(int[][]matrix, Queue<int[]> queue, boolean[][]visited){
        int n = matrix.length, m = matrix[0].length;
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            for(int[] d:dir){
                int x = cur[0]+d[0];
                int y = cur[1]+d[1];
                if(x<0 || x>=n || y<0 || y>=m || visited[x][y] || matrix[x][y] < matrix[cur[0]][cur[1]]){
                    continue;
                }
                visited[x][y] = true;
                queue.offer(new int[]{x, y});
            } 
        }
    }
}
*/