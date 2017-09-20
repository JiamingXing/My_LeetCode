package array;
//O(n) time and O(1) space
//这道题看起来不难 但是自己想的方法很多特殊的test case不通过
//算法漏洞太多 想一想别人的思路是怎么想到的？
public class ShortestUnsortedContinuousSubarray {
	public int findUnsortedSubarray(int[] nums) {
		if (nums == null) {
			return 0;
		}
		int n = nums.length;
		int start = -1;
		int end = -2;
		int min = nums[n-1];
		int max = nums[0];
		for (int i = 0; i < n; i++) {
			//从右到左的降序决定start
			if (nums[n-i-1] <= min) {
				min = nums[n-1-i];
			} else {
				start = n-1-i;
			}
			//从左到右的升序决定end
			if (nums[i] >= max) {
				max = nums[i];
			} else {
				end = i;
			}
		}
		return end - start + 1;
	}
}
