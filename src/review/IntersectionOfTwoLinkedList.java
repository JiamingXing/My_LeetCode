package review;
//这道题和cycle一起总结 因为都有一些类似的tricky成分在。
public class IntersectionOfTwoLinkedList {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if (headA == null || headB == null) {
			return null;
		}
		ListNode a = headA;
		ListNode b = headB;
		while (a != b) {
			a = (a == null) ? headB : a.next;
			b = (b == null) ? headA : b.next;
		}
		return a;
	}
}
