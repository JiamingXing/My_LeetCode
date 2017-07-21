package review;
//这道题加了每个物品的价值，要尽量装满背包的同时价值最大
public class BackpackII {
	public int backPackII(int m, int[] A, int V[]) {
		//state:dp[i]表示装容量为i的最大价值
		int[] dp = new int[m+1];
		//一开始初始化成Integer.MIN_VALUE 应该是0 想想为什么
		for (int i = 0; i <= m; i++) {
			dp[i] = 0;
		}
		for (int i = 0; i < A.length; i++) {
			for (int j = m; j >= A[i]; j--) {
				dp[j] = Math.max(dp[j], dp[j-A[i]] + V[i]);
			}
		}
		int res = 0;
		for (int i = 0; i <= m; i++) {
			res = Math.max(res, dp[i]);
		}
		return res;
	}
}
