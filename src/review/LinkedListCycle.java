package review;

public class LinkedListCycle {
//	public boolean hasCycle(ListNode head) {
//		if (head == null || head.next == null) {
//			return false;
//		}
//		ListNode slow = head;
//		ListNode fast = head.next;
//		while (fast != slow) {
//			if (fast == null || fast.next == null) {
//				return false;
//			}
//			slow = slow.next;
//			fast = fast.next.next;
//		}
//		return true;
//	}
	public boolean hasCycle(ListNode head) {
		if (head == null || head.next == null) {
			return false;
		}
		ListNode slow = head;
		ListNode fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				return true;
			}
		}
		return false;
	}
}
