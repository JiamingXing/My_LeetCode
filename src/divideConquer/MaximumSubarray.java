package divideConquer;
//dp的思想
public class MaximumSubarray {
	public int maxSubArray(int[] nums) {
		int[] dp = new int[nums.length];
		dp[0] = nums[0];
		int max = nums[0];
		for (int i = 1; i < nums.length - 1; i++) {
			dp[i] = dp[i-1] + nums[i] > nums[i] ? dp[i-1] + nums[i] : nums[i];
			max = Math.max(max, dp[i]);
		}
		return max;
	}

}



/*
 public class MaximumSubarray {
	public int maxSubArray(int[] nums) {
		int max =nums[0];
    	int currentMax = nums[0];
    	for(int i = 1; i < nums.length; i++){
        	currentMax = currentMax + nums[i] > nums[i] ? currentMax + nums[i] : nums[i];
        	max = Math.max(max, currentMax);
    	}
    	return max;
	}
}
*/
