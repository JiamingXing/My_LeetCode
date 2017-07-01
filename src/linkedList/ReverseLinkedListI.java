package linkedList;

public class ReverseLinkedListI {
	public ListNode reverseList(ListNode head) {
		if(head == null || head.next == null){
			return head;
		}
//		ListNode dummy = new ListNode(0);
//		dummy.next = head;
		ListNode prev = null;
		while(head != null){
			//需要先把下一个节点的信息存在一个temp里 避免被覆盖掉
			ListNode temp = head.next;
			head.next = prev;
			prev = head;
			head = temp;
		}
		return prev;
	}

}

//递归的写法
/*
public class ReverseLinkedListI {
	public ListNode reverseList(ListNode head) {
	    // recursive solution 
	    return reverseListInt(head, null);
	}

	private ListNode reverseListInt(ListNode head, ListNode newHead) {
	    if (head == null){
			return newHead;
	    }
	    ListNode next = head.next;
	    head.next = newHead;
	    return reverseListInt(next, head);
	}
}
*/