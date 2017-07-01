package array;
//有DP的思想在里面 prefixSum
//用到prefixSum的题目还有好多 比如contiguous subarray, Subarray Sum equals K
//比如minimum subarray我把有的数取相反数然后求maximum subarray结果再取相反就可以了

public class MaximumSubarray {
	public int maxSubArray(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int max = Integer.MIN_VALUE;
		int sum = 0;
		int minSum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			max = Math.max(max, sum - minSum);
			minSum = Math.min(minSum, sum);
		}
		return max;
	}
}



/*
public class MaximumSubarray {
	int max;
	public int maxSubArray(int[] nums) {
		int cur = nums[0];
		max = nums[0];
		for (int i = 1; i < nums.length; i++) {
			cur = Math.max(cur + nums[i], nums[i]);
			max = Math.max(max, cur);
		}
		return max;
	}
}
*/
