package review;
//核心思路是转换成subset sum的问题 但是对于subset sum的问题自己好像也没什么思路
//(sum + target) / 2 = positive part -> subset sum problem
public class TargetSum {
	public int findTargetSumWays(int[] nums, int S) {
		int sum = 0;
		for(int i = 0; i < nums.length; i++) {
			sum += nums[i];
		}
		if (S > sum || (sum + S) % 2 == 1) {
			return 0;
		}
		return subsetSum(nums, (sum + S) / 2);
	}
	private int subsetSum(int[] nums, int target) {
		int[] dp = new int[target + 1];
		dp[0] = 1;
		for (int i = 0; i < nums.length; i++) {
			for (int j = target; j >= nums[i]; j--) {
				dp[j] += dp[j - nums[i]];
			}
		}
		return dp[target];
	}
}
