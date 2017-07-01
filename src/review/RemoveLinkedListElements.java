package review;

public class RemoveLinkedListElements {
	public ListNode removeElements(ListNode head, int val) {
		if (head == null) {
			return head;
		}
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode prev = dummy;
		while (head != null) {
			if (head.val == val) {
				prev.next = head.next;
			} else {
				prev = prev.next;
			}
			head = head.next;
		}
		return dummy.next;
	}
}
