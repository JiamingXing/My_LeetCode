package review;

public class SwapNodesInPairs {
	public ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		return swap(head, head.next);
	}
	private ListNode swap(ListNode A, ListNode B) {
		ListNode next = B.next;
		B.next = A;
		if (next == null) {
			A.next = next;
		} else if (next.next == null) {
			A.next = next;
		} else {
			A.next = swap(next, next.next);
		}
		return B;
	}
}
