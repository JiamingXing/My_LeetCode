package sort;
//快排循环停止的条件是什么
public class QuickSort {
	public void quickSort(int[] nums) {
		helper(nums, 0, nums.length - 1);
	}
	private void helper(int[] nums, int start, int end) {
		if (start < end) {
			int mid = partition(nums, start, end);
			helper(nums, start, mid);
			helper(nums, mid + 1, end);
//			helper(nums, start, mid);
//			helper(nums, mid + 1, end);
		}
	}
	private int partition(int[] nums, int start, int end) {
//		//end作为pivot
//		int target = nums[end];
//		//start - 1作为起始点
//		int i = start - 1;
//		for (int j = start; j <= end - 1; j++) {
//			//如果nums[j] <= pivot 交换 比pivot大会跳过
//			if (nums[j] <= target) {
//				i ++;
//				int temp = nums[i];
//				nums[i] = nums[j];
//				nums[j] = temp;
//			}
//		}
//		//交换pivot和i+1的值 然后返回i+1
//		int temp = nums[i+1];
//		nums[i+1] = nums[end];
//		nums[end] = temp;
//		return i+1;
//		//想一想自己的写法为什么不可以？？
		
		//这样用do while写就对了
		int target = nums[end];
		int j = end + 1;
		int i = start - 1;
		while (i <= j) {
			do {
				i ++;
			} while (nums[i] < target);
			do {
				j --;
			} while (nums[j] > target);
			if (i < j) {
				int temp = nums[i];
				nums[i] = nums[j];
				nums[j] = temp;
			}
		}
		//j的右边肯定都比pivot大于或等于 左边肯定都比pivot小
		return j;
	}
}
