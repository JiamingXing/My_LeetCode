package linkedList;

public class AddTwoNumbers {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2){
		ListNode dummy = new ListNode(0);
		ListNode prev = dummy;
		int tag = 0;
		while(l1 != null || l2 != null || tag != 0){
			ListNode current = new ListNode(0);
			int sum = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + tag;
			current.val = sum % 10;
			tag = sum / 10;
			prev.next = current;
			prev = current;
			
			l1 = (l1 == null) ? l1 : l1.next;
			l2 = (l2 == null) ? l2 : l2.next;
		}
		return dummy.next;
	}

}
