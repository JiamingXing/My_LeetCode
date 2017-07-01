package DynamicProgramming;

public class IntegerBreak {
	public int integerBreak(int n) {
		int[] dp = new int[n+1];
		dp[0] = 1;
		dp[1] = 1;
		dp[2] = 1;
		for(int i = 3; i <= n; i++){
			for(int j = 1; j < i; j ++){
				dp[i] = Math.max(dp[i], j * Math.max(i-j, dp[i-j]));
			}
		}
		return dp[n];
	}

}
