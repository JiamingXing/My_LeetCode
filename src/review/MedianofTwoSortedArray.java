package review;

public class MedianofTwoSortedArray {
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int len = nums1.length + nums2.length;
		if (len % 2 == 1) {
			return (double)helper(nums1, nums2, 0, 0, len / 2 + 1);
		} else {
			return(helper(nums1, nums2, 0, 0, len/2) + helper(nums1, nums2, 0, 0, len/2+1)) / 2.0;
		}
	}
	private int helper(int[] nums1, int[] nums2, int aStart, int bStart, int k) {
		if (aStart > nums1.length) {
			return nums2[bStart + k -1];
		}
		if (bStart > nums2.length) {
			return nums1[aStart + k - 1];
		}
		if (k == 1) {
			return Math.min(nums1[aStart], nums2[bStart]);
		}
		int aKey = aStart + k/2 - 1 < nums1.length ? nums1[aStart + k/2 + 1] : Integer.MAX_VALUE;
		int bKey = bStart + k/2 - 1 < nums2.length ? nums2[bStart + k/2 + 1] : Integer.MAX_VALUE;
		if (aKey < bKey) {
			return helper(nums1, nums2, aStart + k/2, bStart, k - k/2);
		} else {
			return helper(nums1, nums2, aStart, bStart + k/2, k - k/2);
		}
	}
}
