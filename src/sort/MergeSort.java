package sort;
//不能in-place要先copy出来 然后复制回去
public class MergeSort {
	public void mergeSort(int[] nums) {
		divide(nums, 0, nums.length - 1);
	}
	private void divide(int[] nums, int start, int end) {
		if (start == end) {
			return;
		}
		if (start < end) {
			int mid = start + (end - start) / 2;
			divide(nums, start, mid);
			divide(nums, mid+1, end);
			merge(nums, start, mid, end);
		}
	}
	private void merge(int[] nums, int start, int mid, int end) {
		int i = start;
		int j = mid + 1;
		//merge sort不是sort in place的所以需要一个多余的space存储交换的值
		int[] temp = new int[end-start+1];
		int insertPos = 0;
		while (i <= mid || j <= end) {
			int iCur = i <= mid ? nums[i] : Integer.MAX_VALUE;
			int jCur = j <= end ? nums[j] : Integer.MAX_VALUE;
			if (iCur < jCur) {
				temp[insertPos++] = nums[i++];
			} else {
				temp[insertPos++] = nums[j++];
			}
		}
		for (int k = start; k <= end; k++) {
			nums[k] = temp[k-start];
		}
	}
}
