package review;

public class IntegerBreak {
	public int integerBreak(int n) {
		int[] dp = new int[n+1];
		dp[1] = 1;
		for (int i = 2; i <= n; i++) {
			for (int j = 1; j < i; j++) {
				dp[i] = Math.max(dp[i], j * (i-j));
				dp[i] = Math.max(dp[i], j * dp[i-j]);
				dp[i] = Math.max(dp[i], dp[i-j] * dp[j]);
			}
		}
		return dp[n];
	}
}

//这样写好像稍微快一点
/*
public class IntegerBreak {
	public int integerBreak(int n) {
		int[] dp = new int[n+1];
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
*/
