package review;
//在n个物品中挑选若干物品放入背包，做多能装多满？
/*
public class Backpack {
	public int backPack(int m, int[] A) {
		//state : dp[i][j]表示前i个物品中能否找到大小为j的组合
		boolean[][] dp = new boolean[A.length+1][m+1];
//		for (int i = 0; i <= A.length; i++) {
//			dp[i][0] = true;
//		}
		for (int i = 1; i <= A.length; i++) {
			for (int j = 0; j <= m; j++) {
				dp[i][j] = dp[i-1][j];
				if (j >= A[i] && dp[i][j-A[i-1]]) {
					dp[i][j] = true;
				}
			}
		}
		int res = 0;
		for (int i = 1; i <= m; i++) {
			if (dp[A.length][i]) {
				res = Math.max(res, i);
			}
		}
		return res;
	}
}
*/

public class Backpack {
	public int backPack(int m, int[] A) {
		boolean[] dp = new boolean[m+1];
		dp[0] = true;
		for (int i = 0; i < A.length; i++) {
			for (int j = m; j >= A[i]; j--) {
				dp[j] = dp[j] || dp[j-A[i]];
			}
		}
		for (int i = m; i >= 0; i--) {
			if (dp[i]) {
				return i;
			}
		}
		return 0;
	}
}
