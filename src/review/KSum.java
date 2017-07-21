package review;

public class KSum {
	public int kSum(int A[], int k, int target) {
		//dp[i][j][k]表示数组的前i个元素中，取j个元素，和为k的方案总数
		int[][][] dp = new int[A.length+1][k+1][target+1];
		for (int i = 0; i <= A.length; i++) {
			dp[i][0][0] = 1;
		}
		//接下来的三重循环主要就是想清楚循环的顺序
		for (int i = 1; i <= A.length; i ++) {
			for (int j = 1; j <= k && j <= i; j++) {
				for (int t = 1; t <= target; t++) {
					if (t >= A[i-1]) {
						dp[i][j][t] = dp[i-1][j-1][t-A[i-1]];
					}
					dp[i][j][t] += dp[i-1][j][t];
				}
			}
		}
		return dp[A.length][k][target];
	}
}
