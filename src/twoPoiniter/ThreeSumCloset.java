package twoPoiniter;

import java.util.Arrays;

public class ThreeSumCloset {
	public int threeSumClosest(int[] nums, int target) {
		Arrays.sort(nums);
		int result = nums[0] + nums[1] + nums[nums.length - 1];
		for (int i = 0; i <= nums.length - 2; i++) {
			int low = i + 1;
			int high = nums.length - 1;
			while (low < high) {
				int sum = nums[i] + nums[low] + nums[high];
				if(sum == target) {
					return target;
				}
				if (sum > target) {
					high --;
				}
				if (sum < target) {
					low ++;
				}
				if (Math.abs(sum - target) < Math.abs(result - target)) {
					result = sum;
				}
			}
		}
		return result;
	}

}
