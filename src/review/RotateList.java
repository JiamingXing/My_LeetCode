package review;

public class RotateList {
	public ListNode rotateRight(ListNode head, int k) {
		if (head == null || head.next == null) {
			return head;
		}
		int length = getLength(head);
		k = k % length;
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode slow = dummy;
		ListNode fast = dummy;
		for (int i = 0; i < k; i ++) {
			if (fast.next != null) {
				fast =fast.next;
			}
		}
		while (fast.next != null) {
			slow = slow.next;
			fast = fast.next;
		}
		fast.next = dummy.next;
		dummy.next = slow.next;
		slow.next = null;
		return dummy.next;
	}
	private int getLength(ListNode head) {
		int length = 0;
		while (head != null) {
			length ++;
			head = head.next;
		}
		return length;
	}
}
