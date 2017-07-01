package review;

public class FindTheDuplicateNumber {
	public int findDuplicate(int[] nums) {
		int res = 0;
		int[] temp = new int[nums.length - 1];
		for (int i = 0; i < nums.length; i++) {
			temp[nums[i]-1] ++;
		}
		for (int j = 0; j < temp.length; j ++) {
			if (temp[j] > 1) {
				res = j + 1;
				break;
			}
		}
		return res;
	}
}
