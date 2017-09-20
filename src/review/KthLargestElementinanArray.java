package review;

import java.util.PriorityQueue;
//O(nlogk)时间复杂度
//kth largest not the kth distinct element
public class KthLargestElementinanArray {
	public int findKthLargest(int[] nums, int k) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		for (int n : nums) {
			queue.add(n);
			if (queue.size() > k) {
				queue.poll();
			}
		}
		return queue.peek();
	}
}

//这道题还有一个方法就是用quick select做
