package review;
//这道题的状态之间关系也只和前一行有关，所以我们也可以用滚动数组进行空间优化
public class MaximumSquare {
	public int maximalSquare(char[][] matrix) {
		if(matrix.length == 0) {
			return 0;
		}
	    int m = matrix.length;
	    int n = matrix[0].length;
	    int result = 0;
	    //state dp[i][j]表示以(i,j)作为正方形的右下角可以向左上拓展的最大边长
	    int[][] dp = new int[m+1][n+1];
	    for (int i = 1 ; i <= m; i++) {
	    	//初始化自动定义了 第一行和第一列是1就是1 
	        for (int j = 1; j <= n; j++) {
	            if(matrix[i-1][j-1] == '1') {
	                dp[i][j] = Math.min(Math.min(dp[i][j-1] , dp[i-1][j-1]), dp[i-1][j]) + 1;
	                result = Math.max(dp[i][j], result); // update result
	            }
	        }
	    }
	    return result*result;
	}
}
