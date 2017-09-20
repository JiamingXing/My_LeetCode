package review;

public class SearchinRotatedArray {
	public int search(int[] nums, int target) {
		if (nums == null || nums.length == 0) {
            return -1;
        }
        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            //先判断mid在断点左边还是右边？
            //第一个if是在断点左边 nums[start] < nums[mid] nums[mid] > nums[nums.length - 1]
            if (nums[mid] > nums[end]) {
                if (nums[mid] > target && target >= nums[start]) {
                    end = mid;
                } else {
                    start = mid;
                }
            } else {
                if (nums[mid] < target && target <= nums[end]) {
                    start = mid;
                } else {
                    end = mid;
                }
            }
        }
        if (nums[start] == target) {
            return start;
        } else if (nums[end] == target) {
            return end;
        } else {
            return -1;
        }
	}
}
