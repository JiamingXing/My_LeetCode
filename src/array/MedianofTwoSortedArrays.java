package array;
//O(log(m+n))
//如果是merge的方法复杂度应该是O(m+n)
//做之前会考虑到的一些问题，长度之和为奇数和偶数，取中位数的准则会有所不同
//如果我取k/2的时候超过数组的长度的时候处理方式在代码中怎么处理 -- 多余的当做无穷大处理 这个思路很厉害
//还有一些边界条件如何处理 这道题如果想不到当k/2超过数组范围的时候用最大值代替的话 会难写很多
//什么时候递归停止返回 当K = 1的时候找当前的最小值进行返回，那么前提就是Not out of bound
//所以再考虑如果超出数组范围的时候如何处理 
public class MedianofTwoSortedArrays {
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
