package review;

public class RemoveDuplicateFromSortedLinkedListII {
	public ListNode deleteDuplicates(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		head = dummy;
		while (head.next != null && head.next.next != null) {
			if (head.next.val == head.next.next.val) {
				int temp = head.next.val;
				while (head.next != null && head.next.val == temp) {
					head.next = head.next.next;
				}
			} else {
				head = head.next;
			}
		}
		return dummy.next;
	}
}
