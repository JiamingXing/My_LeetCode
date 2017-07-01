package review;

public class RemoveDuplicateSortedArray {
	public int removeDuplicates(int[] nums) {
		int insertPos = 0;
		for (int i = 0; i < nums.length ; i++) {
			if (i + 1 < nums.length && nums[i + 1] == nums[i]) {
				continue;
			}
			nums[insertPos++] = nums[i];
		}
		return insertPos;
	}
}
