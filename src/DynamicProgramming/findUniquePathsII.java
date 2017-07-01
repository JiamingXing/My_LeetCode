package DynamicProgramming;

public class findUniquePathsII {
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
