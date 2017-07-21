package review;
//哪里错了？为什么一定要+1
public class RangeSumQuery2D {
	int[][] dp;
	public RangeSumQuery2D(int[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];
        dp[0][0] = matrix[0][0];
        for (int i = 1; i < matrix.length; i++) {
        	dp[i][0] = dp[i-1][0] + matrix[i][0];
        }
        for (int i = 1; i < matrix[0].length; i++) {
        	dp[0][i] = dp[0][i-1] + matrix[0][i];
        }
        for (int i = 1; i < matrix.length; i++) {
        	for (int j = 1; j < matrix[0].length; j++) {
        		dp[i][j] = dp[i-1][j] + dp[i][j-1] + matrix[i][j] -dp[i-1][j-1];
        	}
        }
    }
	
	public int sumRegion(int row1, int col1, int row2, int col2) {
        return dp[row2][col2] - dp[row2][col1-1] - dp[row1-1][col2] + dp[row1-1][col1-1];
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
