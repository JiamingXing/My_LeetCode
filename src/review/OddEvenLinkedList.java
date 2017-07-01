package review;

public class OddEvenLinkedList {
	public ListNode oddEvenList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode odd = head;
		//记录fast开始的点也就是偶数的第一个点 需要接在最后一个奇数后面
		ListNode start = head.next;
		ListNode even = head.next;
		while (odd.next != null && odd.next.next != null) {
			odd.next = odd.next.next;
			even.next = even.next.next;
			odd = odd.next;
			even = even.next;
		}
		odd.next = start;
		//不要乱加这一句 偶数的最后一个node指向null 如果这个链表长度是奇数的话已经指向null
		//再加一句会null pointer exception
//		even.next = null;
		return dummy.next;
	}
}
