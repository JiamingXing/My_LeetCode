package linkedList;
//O(n) time and O(1) space
//和cycle的题一样需要一些trick
//自己证明一下这个为什么是对的
public class IntersectionTwoLinkedList {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB){
		if(headA == null || headB == null){
			return null;
		}
		ListNode a = headA;
		ListNode b = headB;
		while(a != b){
			a = a == null ? headB : a.next;
			b = b == null ? headA : b.next;
		}
		return a;
	}

}
