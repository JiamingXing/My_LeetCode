package review;

public class RemoveNthNodeFromEnd {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode slow = dummy;
		ListNode fast = dummy;
		ListNode delete = dummy;
		for (int i = 0; i < n; i++) {
			if (fast != null) {
				fast = fast.next;
			}
		}
		delete = delete.next;
		while (fast.next != null) {
			fast = fast.next;
			slow = slow.next;
			delete = delete.next;
		}
		slow.next = delete.next;
		return dummy.next;
	}
}
