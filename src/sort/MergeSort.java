package sort;
//这里我不用全局变量会不会出问题？
public class MergeSort {
	public void mergeSort(int[] nums) {
		divide(nums, 0, nums.length - 1);
	}
	private void divide(int[] nums, int start, int end) {
		if (start < end) {
			int mid = start + (end - start) / 2;
			divide(nums, start, mid);
			divide(nums, mid+1, end);
			merge(nums, start, mid, end);
		}
	}
	private void merge(int[] nums, int start, int mid, int end) {
		int[] temp = new int[nums.length];
		for (int i = start; i < end; i++) {
			temp[i] = nums[i];
		}
		int i = start;
		int j = mid + 1;
		int k = start;
		while (i <= mid && j <= end) {
			if (temp[i] <= temp[j]) {
				nums[k] = temp[i];
				i ++;
			} else {
				nums[k] = temp[j];
				j ++;
			}
			k ++;
		}
		while (i <= mid) {
			nums[k] = temp[i];
			k++;
			i++;
		}
	}
}
