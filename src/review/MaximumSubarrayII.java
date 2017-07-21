package review;
//找到两个不重叠的连续子数组 使他们的和最大
//对于不重叠的问题，我们都可以用分割线的思路解决，我们把问题转换成，分割线左边的最大和右边的最大
//然后遍历分割线求整体的最大值。
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
