package sort;

public class InsertionSort {
	public void insertionSort(int[] nums) {
		int start = 1;
		while (start < nums.length) {
			//从第一个位置开始 遍历数组每次都寻找在这个位置之前的插入位置
			int temp = 0;
			//找对插入位置
			while (temp < start && nums[temp] <= nums[start]) {
				temp ++;
			}
			//如果插入位置是之前的位置 我们把插入位置到当前位置的值都后移一位
			//如果之前的元素都比这个位置小则不需要改变
			if (temp < start) {
				int curPosition = start;
				int curVal = nums[start];
				while (curPosition > temp) {
					nums[curPosition] = nums[curPosition - 1];
					curPosition --;
				}
				//插入到合适的位置
				nums[temp] = curVal;
			}
			start ++;
		}
	}
}
