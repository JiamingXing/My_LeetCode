package linkedList;
//LinkedList 里要学会用dummy node的 可以减少程序出错的机会
//不管我是否对head进行操作，比如删除 有dummy node之后我最后只要
//return dummt.next
//相当于我叫做head的指针一直在往后traversal 但是我实际的“head” 是dummy
//而我要返回一个链表就是返回这个实际的“head” 也就是dummy 
//head = dummy并没有改变链表的结构
public class RemoveDuplicateSortedLinkedListII {
	public ListNode deleteDuplicates(ListNode head) {
		if(head == null || head.next == null){
			return head;
		}
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		head = dummy;
		while(head.next != null && head.next.next != null){
			if(head.next.val == head.next.next.val){
				int temp = head.next.val;
				while(head.next != null && head.next.val == temp){
					//直到我找到第一个不重复的next
					head.next = head.next.next;
				}
			}else{
				head = head.next;
			}
		}
		return dummy.next;
	}

}
