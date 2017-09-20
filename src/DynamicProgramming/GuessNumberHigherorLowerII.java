package DynamicProgramming;
//这道题重在理解题意
public class GuessNumberHigherorLowerII {
	public int getMoneyAmount(int n) {
		int[][] dp = new int[n+1][n+1];
        for (int len = 1; len < n; len++) {
            for (int i = 0; i + len <= n; i++) {
                int j = i + len;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i; k <= j; k++) {
                    dp[i][j] = Math.min(dp[i][j], Math.max(k-1 < i ? 0 : dp[i][k-1], k+1 > j ? 0 : dp[k+1][j]) + k);
                }
            }
        }
        return dp[1][n];
	}
}
