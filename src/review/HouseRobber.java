package review;
//可以用滚动数组进行空间优化？
public class HouseRobber {
	public int rob(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		if (nums.length == 1) {
			return nums[0];
		}
		int[] dp = new int[2];
		dp[0] = nums[0];
		dp[1] = Math.max(nums[0], nums[1]);
		for (int i = 2; i <= nums.length; i++) {
			dp[i%2] = Math.max(nums[i] + dp[(i-2)%2], dp[(i-1)%2]);
		}
		return dp[(nums.length-1)%2];
	}
}

/*
public class HouseRobber {
	public int rob(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int[] dp = new int[nums.length+1];
		dp[0] = 0;
		dp[1] = nums[0];
		for (int i = 2; i <= nums.length; i++) {
			dp[i] = Math.max(nums[i-1] + dp[i-2], dp[i-1]);
		}
		return dp[nums.length];
	}
}
*/
