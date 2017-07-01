package sort;
//快排循环停止的条件是什么
public class QuickSort {
	public void quickSort(int[] nums) {
		helper(nums, 0, nums.length - 1);
	}
	private void helper(int[] nums, int start, int end) {
		if (start < end) {
			int mid = partition(nums, start, end);
			helper(nums, start, mid - 1);
			helper(nums, mid, end);
		}
	}
	private int partition(int[] nums, int start, int end) {
		int target = nums[end];
		while (start <= end) {
			while (start <= end && nums[start] < target) {
				start ++;
			}
			while (start <= end && nums[end] >= target) {
				end --;
			}
			if (start <= end) {
				int temp = nums[start];
				nums[start] = nums[end];
				nums[end] = temp;
				start ++;
				end --;
			}
		}
		return start;
	}
}
