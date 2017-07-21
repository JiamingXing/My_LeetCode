package review;

public class LongestIncreasingSubsequence {
	public int lengthOfLIS(int[] nums) {
		int res = 1;
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int[] dp = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			dp[i] = 1;
		}
		for (int i = 1; i < nums.length; i++) {
			for (int j = 0; j < i; j++) {
				if (nums[j] >= nums[i]) {
					continue;
				}
				dp[i] = Math.max(dp[j]+1, dp[i]);
			}
			res = Math.max(res, dp[i]);
		}
		return res;
	}
}
