package review;
//其实是贪心算法
public class WiggleSubsequence {
	public int wiggleMaxLength(int[] nums) {
		if (nums.length < 2) {
			return nums.length;
		}
		int i = 1;
		while (i < nums.length && nums[i] == nums[i-1]) {
			i ++;
		}
		if (i == nums.length - 1) {
			return 1;
		}
		boolean tag = nums[i] > nums[0];
		int prev = nums[0];
		int res = 1;
		for (int j = i; j < nums.length; j++) {
			if ((nums[j] > prev && tag) || (nums[j] < prev && !tag)) {
				tag = !tag;
				res ++;
			}
			prev = nums[j];
		}
		return res;
	}
}
