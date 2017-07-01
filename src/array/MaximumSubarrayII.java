package array;
//这道题要求有不over-lapping的两个subarray sum最大
//对于这种不overlapping的问题 要想到一条分割线的思想
//分别统计左右两边的sum放在数组里 然后移动分割线求最大值
public class MaximumSubarrayII {
	public int maxTwoSubarrays(int[] nums) {
		int[] left = new int[nums.length];
		int[] right = new int[nums.length];
		int sum = 0;
		int minSum = 0;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			max = Math.max(max, sum - minSum);
			minSum = Math.min(minSum, sum);
			left[i] = max;
		}
		sum = 0;
		minSum = 0;
		max = Integer.MIN_VALUE;
		for (int i = nums.length - 1; i >= 0; i--) {
			sum += nums[i];
			max = Math.max(max, sum - minSum);
			minSum = Math.min(minSum, sum);
			right[i] = max;
		}
		max = Integer.MIN_VALUE;
		for (int i = 0; i < nums.length - 1; i++) {
			max = Math.max(max, left[i] + right[i+1]);
		}
		return max;
	}
}
