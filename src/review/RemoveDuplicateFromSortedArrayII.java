package review;

public class RemoveDuplicateFromSortedArrayII {
	public int removeDuplicates(int[] nums) {
		int insertPos = 0;
		for (int n : nums) {
			if (insertPos < 2 || n > nums[insertPos]) {
				nums[insertPos ++] = n;
			}
		}
		return insertPos;
	}
}
