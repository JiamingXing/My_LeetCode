package linkedList;
public class RotateList {
	public ListNode rotateRight(ListNode head, int k){
		if(head == null || head.next == null){
			return head;
		}
		int length = getLength(head);
		//k可能比length还大。。但是这种情况当时没考虑到 要取模
		k = k % length;
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		head = dummy;
		ListNode tail = dummy;
		for(int i = 0; i < k ; i++){
			head = head.next;
		}
		while(head.next != null){
			tail = tail.next;
			head = head.next;
		}
		head.next = dummy.next;
		dummy.next = tail.next;
		tail.next = null;
		return dummy.next;
	}
	private int getLength(ListNode head){
		int length = 0;
		while(head != null){
			length ++;
			head = head.next;
		}
		return length;
	}
	
}





//这个自己写的错误程序思路和狗屎一样。。很烂 总结一下！
/*
public class RotateList {
	public ListNode rotateRight(ListNode head, int k){
		if(head == null || head.next == null){
			return head;
		}
		//find tail
		ListNode temp = head;
		while(temp != null && temp.next != null){
			temp = temp.next;
		}
		ListNode tail = temp;
		ListNode gap = gapPosition(head, k);
		ListNode head1 = head;
		ListNode head2 = gap.next;
		gap.next = null;
		tail.next = head1;
		return head2;
	}
	private ListNode gapPosition(ListNode head, int k){
		int length = 0;
		ListNode current = head;
		while(current != null){
			length ++;
			current = current.next;
		}
		current = head;
		for(int i = length; i > length - k; i --){
			current = current.next;
		}
		return current;
	}
}
*/
