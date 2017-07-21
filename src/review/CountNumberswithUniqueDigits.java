package review;

public class CountNumberswithUniqueDigits {
	public int countNumbersWithUniqueDigits(int n) {
		if (n > 10) {
			return 0;
		}
		if (n == 0) {
			return 1;
		}
		int[] dp = new int[n+1];
		dp[0] = 0;
		dp[1] = 9;
		for (int i = 2; i <= n; i++) {
			dp[i] = dp[i-1] * (11 - i);
		}
		int res = 0;
		for (int i = 1; i < dp.length; i++) {
			res += dp[i];
		}
		return res+1;
	}
}
