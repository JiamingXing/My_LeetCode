package review;

public class FindPeakElement {
	public int findPeakElement(int[] nums) {
		int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if ((mid - 1 == -1 || nums[mid] > nums[mid - 1]) && (mid + 1 == nums.length || nums[mid] > nums[mid + 1])) {
                return mid;
            } else if (nums[mid - 1] > nums[mid] && (mid + 1 == nums.length || nums[mid] > nums[mid + 1])) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if ((start - 1 == - 1 || nums[start - 1] < nums[start]) && (start + 1 == nums.length || nums[start] > nums[start + 1])) {
            return start;
        } else {
            return end;
        }
	}
}
