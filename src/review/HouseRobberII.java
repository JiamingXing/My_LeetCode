package review;

public class HouseRobberII {
	public int rob(int[] nums) {
		//这道题可以转换成两种情况，考虑头尾取不取的情况
		if (nums == null || nums.length == 0) {
			return 0;
		}
		if (nums.length == 1) {
			return nums[0];
		}
		return Math.max(helper(nums, 0, nums.length - 2), helper(nums, 1, nums.length - 1));
	}
	private int helper(int[] nums, int start, int end) {
		if (start == end) {
			return nums[start];
		}
		int dp[] = new int[end - start + 2];
		dp[0] = 0;
		dp[1] = nums[start];
		for (int i = 2; i <= end - start + 1; i ++) {
			dp[i] = Math.max(dp[i-1], dp[i-2] + nums[start + i - 1]);
		}
		return dp[end - start + 1];
	}
}
