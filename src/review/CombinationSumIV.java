package review;
//这道题思路是怎么想到的？
public class CombinationSumIV {
	public int combinationSum4(int[] nums, int target) {
		int[] dp = new int[target + 1];
        dp[0] = 1;
        //这里一定要从小到target的顺序循环？
//        for (int i = 1; i <= nums.length; i++) {
//        	for (int j = target; j >= nums[i-1]; j--) {
//        		dp[j] += dp[j-nums[i-1]];
//        	}
//        }
        for (int i = 1; i <= target; i++) {
        	for (int j = 0; j < nums.length; j++) {
        		if (nums[j] > i) {
        			continue;
        		}
        		dp[i] += dp[i-nums[j]];
        	}
        }
        return dp[target];
	}
}
