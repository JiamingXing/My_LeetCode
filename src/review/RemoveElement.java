package review;

public class RemoveElement {
	public int removeElement(int[] nums, int val) {
		int insertPos = 0;
		for (int i = 0; i < nums.length; i ++) {
			if (nums[i] != val) {
				nums[insertPos++] = nums[i];
			}
		}
		return insertPos + 1;
	}
}
