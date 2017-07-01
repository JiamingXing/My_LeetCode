package linkedList;

public class RemoveDuplicateSortedLinkedListI {
	public ListNode deleteDuplicates(ListNode head){
		if(head == null || head.next == null){
			return head;
		}
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		head = dummy;
		while(head.next != null && head.next.next != null){
			//保留第一个点 不管重复还是不重复
			head = head.next;
			if(head.val == head.next.val){
				int temp = head.val;
				//找到第一个不相等的next
				while(head.next != null && head.next.val == temp){
					head.next = head.next.next;
				}
			}
		}
		return dummy.next;
	}
}
