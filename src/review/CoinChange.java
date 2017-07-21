package review;
//看题目应该是背包型动态规划
public class CoinChange {
	public int coinChange(int[] coins, int amount) {
		if (amount == 0) {
			return 0;
		}
		int[] dp = new int[amount+1];
		dp[0] = 0;
		for (int i = 1; i <= amount; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
		for (int i = 1; i <= amount; i++) {
			for (int j = 0; j < coins.length; j++) {
				if (coins[j] > i) {
					continue;
				}
				if (dp[i - coins[j]] == Integer.MAX_VALUE) {
					continue;
				}
				dp[i] = Math.min(dp[i], dp[i-coins[j]]+1); 
			}
		}
		return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
	}
}
