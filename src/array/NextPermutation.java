package array;

import java.util.Arrays;

//1,2,3 -> 1,3,2  3,2,1 -> 1,2,3  1,1,5 -> 1,5,1  2,3,1 -> 3,1,2
//in place and no extra memory
public class NextPermutation {
	public void nextPermutation(int[] nums) {
		int n = nums.length - 2;
		while (n >= 0 && nums[n] >= nums[n+1]) {
			n--;
		}
		if (n == -1) {
			Arrays.sort(nums);
		} else {
			int pos = n+1;
			while (pos < nums.length && nums[pos] > nums[n]) {
				pos ++;
			}
			pos --;
			int temp = nums[pos];
			nums[pos] = nums[n];
			nums[n] = temp;
			Arrays.sort(nums, n+1, nums.length);
		}
	}
}
