package review;

public class MinimumSizeSubarraySum {
	public int minSubArrayLen(int s, int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int sum = 0;
		int start = 0;
		int end = 0;
		int min = Integer.MAX_VALUE;
		while (end < start) {
			sum += nums[end++];
			while (sum >= s) {
				min = Math.min(min, end - start);
				sum -= nums[start++];
			}
		}
		return min == Integer.MIN_VALUE ? 0 : min;
	}
}
