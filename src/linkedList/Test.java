package linkedList;

public class Test {
	public static void main(String[] args) {
		ReverseNodesKGroup s = new ReverseNodesKGroup();
		ListNode dummy = new ListNode(0);
		ListNode head = dummy;
		for (int i = 1; i <= 2; i++) {
			head.next = new ListNode(i);
			head = head.next;
		}
		head.next = null;
		s.reverseKGroup(dummy.next, 2);
	}
}
