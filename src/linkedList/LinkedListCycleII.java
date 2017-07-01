package linkedList;
//相对于I 的话这个也很tricky 在相遇之后将慢指针移到起点然后步调相同
//再次相遇的时候就是cycle的起点
public class LinkedListCycleII {
	public ListNode detectCycle(ListNode head) {
		ListNode fast = head.next;
		ListNode slow = head;
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			if (slow == fast) {
				while (head != slow) {
					head = head.next;
					slow = slow.next;
				}
				return slow;
			}
		}
		return null;
	}

}
