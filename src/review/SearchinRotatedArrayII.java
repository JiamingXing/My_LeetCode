package review;
//允许重复元素存在
//有重复元素只能写for循环O(n)去做 已经不能使用二分法了
//看看能不否证明不能用二分法来做
public class SearchinRotatedArrayII {
	public boolean search(int[] nums, int target) {
//		for (int i = 0; i < nums.length; i++) {
//            if (nums[i] == target) {
//                return true;
//            }
//        }
//        return false;
		if (nums == null || nums.length == 0) {
            return false;
        }
		int start = 0;
		int end = nums.length - 1;
		while (start + 1 < end) {
			int mid = start + (end - start) / 2;
			if (nums[mid] == target) {
				return true;
			}
			//用||是因为有重复的情况如果nums[mid] = nums[start] 还可以去判断比nums[end]大
			if (nums[mid] > nums[start] || nums[mid] > nums[end]) {
				if (target >= nums[start] && nums[mid] > target) {
					end = mid;
				} else {
					start = mid;
				}
			} else if (nums[mid] < nums[end] || nums[mid] < nums[start]) {
				if (nums[mid] < target && target <= nums[end]) {
					start = mid;
				} else {
					end = mid;
				}
				//如果nums[mid]和start end都相等而且都不是我们要找的 我们就舍去end
			} else {
				end --;
			}
		}
		if (nums[start] == target) {
			return true;
		} else if (nums[end] == target) {
			return true;
		} else {
			return false;
		}
	}
}
