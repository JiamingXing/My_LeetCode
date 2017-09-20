package review;

public class RemoveDuplicateSortedArray {
	public int removeDuplicates(int[] nums) {
		int insertPos = 0;
		for (int i = 0; i < nums.length ; i++) {
			//核心思路就是不管当前元素是不是重复
			//我们都找当前这个元素在该数组中最后一个出现的元素插入到我们的curPos当中
			if (i + 1 < nums.length && nums[i + 1] == nums[i]) {
				continue;
			}
			nums[insertPos++] = nums[i];
		}
		return insertPos;
	}
}
