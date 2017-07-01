package review;

public class InsertionSortList {
	public ListNode insertionSortList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
//		ListNode dummy = new ListNode(0);
//		dummy.next = new ListNode(head.val);
//		head = head.next;
//		ListNode prev = dummy;
//		ListNode cur = dummy.next;
//		ListNode tail = dummy.next;
//		tail.next = null;
//		while (head != null) {
//			while (cur != null && cur.val < head.val) {
//				prev = cur;
//				cur = cur.next;
//			}
//			if (cur == null) {
//				prev.next = new ListNode(head.val);
//				tail = prev.next;
//			} else {
//				prev.next = new ListNode(head.val);
//				prev.next.next = cur;
//			}
//			prev = dummy;
//			head = head.next;
//			cur = dummy.next;
//		}
//		tail.next = null;
//		return dummy.next;
		
		// in place 
		ListNode dummy = new ListNode(0);
		dummy.next= head;
		ListNode iter = head.next;
		ListNode prev = dummy;
		ListNode cur = dummy.next;
		ListNode tail = dummy.next;
		tail.next = null;
		while (iter != null) {
			while (cur != null && cur.val < iter.val) {
				prev = cur;
				cur = cur.next;
			}
			ListNode next = iter.next;
			if (cur == null) {
				prev.next = iter;
				tail = iter;
				tail.next = null;
			} else {
				prev.next = iter;
				iter.next = cur;
			}
			prev = dummy;
			cur = dummy.next;
			iter = next;
		}
		return dummy.next;
	}
}
