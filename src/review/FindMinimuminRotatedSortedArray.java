package review;

public class FindMinimuminRotatedSortedArray {
	//这道题转换成find the first smaller than last element
	public int findMin(int[] nums) {
		int n = nums.length;
        int target = nums[n-1];
        int start = 0;
        int end = n - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] <= target) {
                end = mid;
            } else if (nums[mid] > target) {
                start = mid;
            }
        }
        if (nums[start] <= target) {
            return nums[start];
        } else {
            return nums[end];
        }
	}
}
