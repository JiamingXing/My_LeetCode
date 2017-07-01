package array;

import java.util.Arrays;
//这是最笨的方法，时间复杂度为n^3 想想如何改进
//public class ValidateTriangle {
//	public int triangleNumber(int[] nums) {
//		Arrays.sort(nums);
//		int res = 0;
//		for (int i = 0; i < nums.length - 2; i++) {
//			for (int j = i+1; j < nums.length - 1; j++) {
//				int temp = nums[i] + nums[j];
//				for (int k = j + 1; j < nums.length; k++) {
//					if (nums[k] >= temp) {
//						break;
//					}
//					res ++;
//				}
//			}
//		}
//		return res;
//	}
//}
//这种思路就和 3sum 4sum two pointer的思路很像。
public class ValidateTriangle {
	public int triangleNumber(int[] nums) {
		Arrays.sort(nums);
		int res = 0;
		for (int i = nums.length - 1; i >= 2; i--) {
			int start = 0;
			int end = i - 1;
			while (start < end) {
				if (nums[start] + nums[end] > nums[i]) {
					res += end - start;
					end --;
				} else {
					start ++;
				}
			}
		}
		return res;
	}
}
