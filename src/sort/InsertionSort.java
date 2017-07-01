package sort;

public class InsertionSort {
	public void insertionSort(int[] nums) {
		int start = 1;
		while (start < nums.length) {
			int temp = 0;
			while (temp < start && nums[temp] > nums[start]) {
				temp ++;
			}
			if (temp < start) {
				int cur = start;
				int curVal = nums[start];
				cur --;
				while (cur >= temp) {
					nums[cur + 1] = nums[cur];
					cur --;
				}
				nums[temp] = curVal;
			}
			start ++;
		}
	}
}
