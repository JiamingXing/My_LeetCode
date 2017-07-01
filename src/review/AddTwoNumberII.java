package review;
//学习一下Add Two Number的写法 更好一些
public class AddTwoNumberII {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if (l1 == null) {
			return l2;
		}
		if (l2 == null) {
			return l1;
		}
		ListNode head1 = reverse(l1);
		ListNode head2 = reverse(l2);
		ListNode dummy = new ListNode(0);
		ListNode cur = dummy;
		int carry = 0;
//		while (head1 != null || head2 != null) {
//			if (head1 == null) {
//				cur.next = new ListNode(head2.val + carry >= 10 ? (head2.val + carry- 10) : (head2.val + carry));
//				carry = head2.val + carry >= 10 ? 1 : 0;
//				head2 = head2.next;
//			} else if (head2 == null) {
//				cur.next = new ListNode(head1.val + carry >= 10 ? (head1.val + carry- 10) : (head1.val + carry));
//				carry = head1.val + carry >= 10 ? 1 : 0;
//				head1 = head1.next;
//			} else {
//				cur.next = new ListNode(head1.val + head2.val + carry >= 10 ? (head1.val + head2.val + carry - 10) : (head1.val + head2.val + carry));
//				carry = head1.val + head2.val + carry >= 10 ? 1 : 0;
//				head1 = head1.next;
//				head2 = head2.next;
//			}
//			cur = cur.next;
//		}
//		if (carry == 1) {
//			cur.next = new ListNode(1);
//		}
		while (head1 != null || head2 != null || carry != 0) {
			int sum = (head1 == null ? 0 : head1.val) + (head2 == null ? 0 : head2.val) + carry;
			cur.next = new ListNode(sum >= 10 ? (sum - 10) : sum);
			carry = sum >= 10 ? 1 : 0;
			head1 = head1 == null ? head1 : head1.next;
			head2 = head2 == null ? head2 : head2.next;
		}
		return reverse(dummy.next);
	}
	private ListNode reverse(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode prev = null;
		while (head != null) {
			ListNode next = head.next;
			head.next = prev;
			prev = head;
			head = next;
		}
		return prev;
	}
}
