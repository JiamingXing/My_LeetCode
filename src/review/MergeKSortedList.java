package review;

import java.util.PriorityQueue;

public class MergeKSortedList {
	public ListNode mergeKLists(ListNode[] lists) {
		if (lists == null || lists.length == 0) {
			return null;
		}
		PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
			@Override
			public int compare(ListNode o1, ListNode o2) {
				if (o1.val < o2.val) {
					return -1;
				} else if (o1.val == o2.val) {
					return 0;
				} else {
					return 1;
				}
			}
		});
	}
}
