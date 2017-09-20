package binarySearch;

public class SearchForaRange {
	public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 2) {
        	return new int[]{-1, -1};
        }
        int[] res = new int[2];
        int start = 0;
        int end = nums.length - 1;
        //left bound
        while (start + 1 < end) {
        	int mid = start + (end - start) / 2;
        	if (nums[mid] < target) {
        		start = mid;
        	} else {
        		end = mid;
        	}
        }
        if (nums[start] == target) {
        	res[0] = start;
        } else if (nums[end] == target) {
        	res[0] = end;
        } else {
        	res[0] = -1;
        	res[1] = -1;
        	return res;
        }
        // right bound
        start = 0;
        end = nums.length - 1;
        while (start + 1 < end) {
        	int mid = start + (end - start) / 2;
        	if (nums[mid] > target) {
        		end = mid;
        	} else {
        		start = mid;
        	}
        }
        if (nums[end] == target) {
        	res[1] = end;
        } else {
        	res[1] = start;
        }
        return res;
    }
}
