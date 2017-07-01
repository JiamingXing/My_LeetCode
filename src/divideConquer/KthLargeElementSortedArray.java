package divideConquer;
//这道题怎么体现divide-and-conquer的思想的？？
//divide and conquer   quick select 结合的思路 不是自己想的好好体会
public class KthLargeElementSortedArray {
	public int findKthLargest(int[] nums, int k) {
		int l = nums.length;
		int p = quickSelect(nums, 0, l-1, l-k+1);
		return nums[p];
	}
	private int quickSelect(int[] nums, int start, int end, int sec) {
		//use quick sort's idea 
		//put nums that are <= pivot to the left
		//put nums that are >= pivot to the right
		int i = start;
		int j = end;
		int pivot = nums[sec];
		while (i < j) {
			if (nums[i++] > pivot) {
				swap(nums, --i, --j);
			}
		}
		swap(nums, i, end);
		
	}

}
