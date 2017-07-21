package review;
//这道题给你一个数组，每个数组的值表示硬币的价值，然后每次可以取一个或者两个
//比较先手的人会赢吗
public class CoinsInaLineII {
	public boolean firstWillWin(int[] values) {
		int n = values.length;
		int[] dp = new int[n+1];
		boolean[] flag = new boolean[n+1];
		int[] sum = new int[n+1];
		for (int i = n-1; i >= 1; i --) {
			sum[i] += sum[i+1] + values[i-1];
		}
		return sum[n] < 2 * MemorySearch(n, dp, flag, values, sum);
	}
	private int MemorySearch(int n, int[] dp, boolean[] flag, int[] values, int[] sum) {
		if (flag[n] == true) {
			return dp[n];
		}
		if (n == 0) {
			dp[n] = 0;
		} else if (n == 1) {
			dp[n] = values[n-1];
		} else if (n == 2) {
			dp[n] = values[n-1] + values[n-2];
		} else {
			dp[n] = sum[n] - Math.min(MemorySearch(n-1, dp, flag, values, sum), MemorySearch(n-2, dp, flag, values, sum));
		}
		flag[n] = true;
		return dp[n];
	}
}


//for循环从大到小的递归
/*
public class CoinsInaLineII {
	public boolean firstWillWin(int[] values) {
		int n = values.length;
		int[] sumN = new int[n+1];
		sumN[0] = 0;
		int sum = 0;
		//sumN[] 表示什么？表示后i个硬币的价值总和
		//一开始想的是从头开始加 但是明显不对了就
		for (int i = 1; i <= n; i++) {
			sum += values[n-i];
			sumN[i] = sum;
		}
		//state dp[i]表示还剩i个硬币，现在先手取硬币的人能拿到的最高价值
		int[] dp = new int[n+1];
		dp[0] = 0;
		dp[1] = values[n-1];
		for (int i = 1; i <= n; i++) {
			dp[i] = sumN[i] - Math.min(dp[i-1], dp[i-2]);
		}
		return dp[n] > sumN[n] / 2;
	}
}
*/
