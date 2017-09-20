package divideConquer;
//好题
public class MedianOfTwoSortedArray {
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int len = nums1.length + nums2.length;
		if (len % 2 == 1) {
			return (double)findMiddle(nums1, nums2, 0, 0, len/2 + 1);
		} else {
			return (findMiddle(nums1, nums2, 0, 0, len / 2) + findMiddle(nums1, nums2, 0, 0, len / 2 + 1)) / 2.0;
		}
	}
	private int findMiddle(int[] A, int[] B, int aStart, int bStart, int k) {
		if (aStart >= A.length) {
			return B[bStart + k - 1];
		}
		if (bStart >= B.length) {
			return A[aStart + k - 1];
		}
		if (k == 1) {
			return Math.min(A[aStart], B[bStart]);
		}
		int aKey = aStart + k / 2 - 1 < A.length ? A[aStart+k/2-1] : Integer.MAX_VALUE;
		int bKey = bStart + k / 2 - 1 < B.length ? B[bStart+k/2-1] : Integer.MAX_VALUE;
		if (aKey < bKey) {
			return findMiddle(A, B, aStart+k/2, bStart, k-k/2);
		} else {
			return findMiddle(A, B, aStart, bStart+k/2, k-k/2);
		}
	}
}
