package review;

import java.util.Arrays;

public class TreeSumClosest {
	public int threeSumClosest(int[] nums, int target) {
		Arrays.sort(nums);
		int min = Integer.MAX_VALUE;
		int res = 0;
		for (int i = 0; i < nums.length - 2; i++) {
			if (i > 0 && nums[i] == nums[i-1]) {
				continue;
			}
			int start = i + 1;
			int end = nums.length - 1;
			while (start < end) {
				int curSum = nums[start] + nums[end] + nums[i];
				if (curSum == target) {
					return target;
				}
				if (curSum > target) {
					end --;
				}
				if (curSum < target) {
					start ++;
				}
				if (Math.abs(curSum - target) < min) {
					min = Math.abs(curSum - target);
					res = curSum;
				}
			}
		}
		return res;
	}
}
