package review;
//有n个硬币排成一条线，从右到左依次拿一个或两个直到没硬币为止，拿到最后一个硬币获胜
//从大到小记忆化搜索
public class CoinsInaLine {
	public boolean firstWillWin(int n) {
		boolean[] dp = new boolean[n+1];
		boolean[] flag = new boolean[n+1];
		return MemorySearch(n, dp, flag);
	}
	private boolean MemorySearch(int i, boolean[] dp, boolean[] flag) {
		if (flag[i] == true) {
			return dp[i];
		}
		if (i == 0) {
			dp[i] = false;
		} else if (i == 1) {
			dp[i] = true;
		} else if (i == 2) {
			dp[i] = true;
		} else {
			dp[i] = !MemorySearch(i-1, dp, flag) || !MemorySearch(i-2, dp, flag);
		}
		flag[i] = true;
		return dp[i];
	}
}

//从小到大循环DP
/*
public class CoinsInaLine {
	public boolean firstWillWin(int n) {
		boolean[] dp = new boolean[n+1];
		dp[0] = false;
		dp[1] = true;
		for (int i = 2; i <= n; i++) {
			dp[i] = (!dp[i-1]) || (!dp[i-2]);
		}
		return dp[n];
	}
}
*/
