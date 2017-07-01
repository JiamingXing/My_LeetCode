package linkedList;
//这道题不用extra space的话就比较tricky 需要用快慢指针来做 
public class LinkedListCycle {
	public boolean hasCycle(ListNode head) {
		if (head == null || head.next == null) {
			return false;
		}
		ListNode fast = head.next;
		ListNode slow = head;
		while (fast != slow) {
			if (fast == null || fast.next == null) {
				return false;
			}
			fast = fast.next.next;
			slow = slow.next;
		}
		return true;
	}
}
