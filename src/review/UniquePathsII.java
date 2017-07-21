package review;

public class UniquePathsII {
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int row = obstacleGrid.length;
        int column = obstacleGrid[0].length;
        int rowTag = 0;
        int colTag = 0;
        int[][] result = new int[row][column];
        // initialization of first row and column
        for(int i =0; i < column; i ++){
            rowTag = Math.max(rowTag, obstacleGrid[0][i]);
            if(rowTag == 1){
                result[0][i] = 0;
            }else{
                result[0][i] = 1;
            }
        }
        for(int j = 0; j < row; j ++){
            colTag = Math.max(colTag, obstacleGrid[j][0]);
            if(colTag == 1){
                result[j][0] = 0;
            }else{
                result[j][0] = 1;
            }
        }
        for(int m = 1; m < row; m ++){
            for(int n = 1; n < column; n ++){
                if(obstacleGrid[m][n] == 1){
                    result[m][n] = 0;
                }else{
                    if(obstacleGrid[m-1][n] == 1 && obstacleGrid[m][n-1] == 1){
                        result[m][n] = 0;
                    }else if(obstacleGrid[m-1][n] == 1){
                        result[m][n] = result[m][n-1];
                    }else if(obstacleGrid[m][n-1] == 1){
                        result[m][n] = result[m-1][n];
                    }else{
                        result[m][n] = result[m][n-1] + result[m-1][n];
                    }
                    
                }
            }
        }
        return result[row-1][column-1];
	}
}

//相对下面的没有extra space 而且简化了很多if语句操作 
/*
public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        
        //flip upper left cell (the start cell): 1 => 0 or 0 => 1
        obstacleGrid[0][0] ^= 1;
        
        //first row: if 1, then 0; otherwise, left cell
        for(int i = 1; i < n; i++)
            obstacleGrid[0][i] = obstacleGrid[0][i] == 1 ? 0 : obstacleGrid[0][i - 1];
        
        //first column: if 1, then 0; otherwise, top cell
        for(int i = 1; i < m; i++)
            obstacleGrid[i][0] = obstacleGrid[i][0] == 1 ? 0 : obstacleGrid[i - 1][0];
            
        //rest: if 1, then 0; otherwise, left cell + top cell
        for(int i = 1; i < m; i++)
            for(int j = 1; j < n; j++)
                obstacleGrid[i][j] = obstacleGrid[i][j] == 1 ? 0 : obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
                
        //return lower right cell (the end cell)
        return obstacleGrid[m - 1][n - 1];
    }
}
*/

//看看别人的程序为什么这么短
/*
public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    int width = obstacleGrid[0].length;
    int[] dp = new int[width];
    dp[0] = 1;
    for (int[] row : obstacleGrid) {
        for (int j = 0; j < width; j++) {
            if (row[j] == 1)
                dp[j] = 0;
            else if (j > 0)
                dp[j] += dp[j - 1];
        }
    }
    return dp[width - 1];
}
*/
