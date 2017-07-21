package review;
//这道题不能用贪心算法做，试着证明一下？
public class StoneGame {
	public int stoneGame(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int n = nums.length;
		int[][] dp = new int[n][n];
		int[][] visit = new int[n][n];
		for (int i = 0; i < n; i++) {
			dp[i][i] = 0;
		}
		int[][] sum = new int[n][n];
		for (int i = 0; i < n; i++) {
			sum[i][i] = nums[i];
			for (int j = i+1; j < n; j++) {
				sum[i][j] = sum[i][j-1] + nums[j];
			}
		}
		return helper(0, n-1, dp, visit, sum);
	}
	private int helper(int start, int end, int[][] dp, int[][] visit, int[][] sum) {
		if (visit[start][end] == 1) {
			return dp[start][end];
		}
		if (start == end) {
			visit[start][end] = 1;
			return dp[start][end];
		}
		dp[start][end] = Integer.MAX_VALUE;
		for (int i = start; i < end; i++) {
			dp[start][end] = Math.min(dp[start][end], helper(start, i, dp, visit, sum) + helper(i+1, end, dp, visit, sum)) + sum[start][end];
		}
		visit[start][end] = 1;
		return dp[start][end];
	}
}
