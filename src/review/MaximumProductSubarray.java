package review;
//我遍历数组相乘，当前位置的结果不是该位置的最小，就是最大
public class MaximumProductSubarray {
	public int maxProduct(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int res = nums[0];
		int min = nums[0];
		int max = nums[0];
		for (int i = 1; i < nums.length; i++) {
		    int temp = min;
			min = Math.min(Math.min(max * nums[i], temp * nums[i]), nums[i]);
			max = Math.max(Math.max(max * nums[i], temp * nums[i]), nums[i]);
			res = Math.max(max, res);
		}
		return res;
	}
}
