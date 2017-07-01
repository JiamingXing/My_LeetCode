package array;
//这道题的思路是怎么想到的 数组里所有元素均为正整数
//如何保证求出来的长度是最小的 有考虑所有的可能吗？
public class MinimumSizeSubarraySum {
	public int minSubArrayLen(int s, int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int sum = 0;
		int start = 0;
		int end = 0;
		int min = Integer.MAX_VALUE;
		while (end < nums.length) {
			sum += nums[end++];
			while (sum >= s) {
				min = Math.min(min, end - start);
				sum -= nums[start++];
			}
		}
		return min == Integer.MAX_VALUE ? 0 : min;
	}
}
