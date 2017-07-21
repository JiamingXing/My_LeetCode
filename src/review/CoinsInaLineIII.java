package review;
//这个问题变成我每次可以从头取一个硬币或者从尾取一个硬币，问你先手能否获胜？
public class CoinsInaLineIII {
	public boolean firstWillWin(int[] values) {
		int n = values.length;
		//state: dp[i][j]表示还剩下i到j的硬币的时候 先手取硬币到最后能获得最大的价值
		int[][] dp = new int[n+1][n+1];
		int[][] sum = new int[n+1][n+1];
		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {
				sum[i][j] = i == j ? values[j] : (sum[i][j-1] + values[j]);
			}
		}
		boolean[][] flag = new boolean[n+1][n+1];
		int allSum = 0;
		for (int now : values) {
			allSum += now;
		}
		return MemorySearch(0, values.length - 1, dp, flag, values, sum) > allSum / 2;
	}
	private int MemorySearch(int left, int right, int[][] dp, boolean[][] flag, int[] values, int[][] sum) {
		//真的有必要用到记忆化搜索吗？会变快？感觉每次都用不到true的时候return这一项？
		if (flag[left][right]) {
			return dp[left][right];
		}
		if (left > right) {
			dp[left][right] = 0;
		} else if (left == right) {
			dp[left][right] = values[left];
		} else {
			//方程应该就等于dp[i][j] = sum[i][j] - min(dp[i+1][j], dp[i][j-1])
			//相当于dp[i+1][j] dp[i][j-1]表示对手先手的回合能拿到最少的价值，那么对应我这个回合最高的价值
			int temp = Math.min(MemorySearch(left+1, right, dp, flag, values, sum), MemorySearch(left, right-1, dp, flag, values, sum));
			dp[left][right] = sum[left][right] - temp;
		}
		flag[left][right] = true;
		return dp[left][right];
	}
}
