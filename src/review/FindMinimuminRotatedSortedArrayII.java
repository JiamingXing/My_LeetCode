package review;

public class FindMinimuminRotatedSortedArrayII {
	//  这道题目在面试中不会让写完整的程序
    //  只需要知道最坏情况下 [1,1,1....,1] 里有一个0
    //  这种情况使得时间复杂度必须是 O(n)
    //  因此写一个for循环就好了。
    //  如果你觉得，不是每个情况都是最坏情况，你想用二分法解决不是最坏情况的情况，那你就写一个二分吧。
    //  反正面试考的不是你在这个题上会不会用二分法。这个题的考点是你想不想得到最坏情况。
	public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > nums[end]) {
                start = mid;
                //如果mid == end 我们把end删除 因为不影响我们对最小的求解
                //所以worst case也不可能达到O(logn)
            } else if (nums[mid] == nums[end]) {
                end --;
            } else {
                end = mid;
            }
        }
        if (nums[start] <= nums[end]) {
            return nums[start];
        } else {
            return nums[end];
        }
    }
}
