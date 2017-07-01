package review;

public class LinkedListCycleII {
	public ListNode detectCycle(ListNode head) {
		if (head == null || head.next == null) {
			return null;
		}
		ListNode fast = head.next;
		ListNode slow = head;
		while (fast != null || fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			if (slow == fast) {
				while (head != slow) {
					slow = slow.next;
					head = head.next;
				}
				return slow;
			}
		}
		return null;
	}
}
