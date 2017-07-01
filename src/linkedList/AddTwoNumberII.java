package linkedList;
//What if you cannot modify the input lists? In other words, reversing the lists is not allowed.
//感觉初步写这道题感觉自己的程序写的有点冗长，很多多余的语句？
//而且有case不通过说明肯定是方法不对
public class AddTwoNumberII {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode head1 = reverse(l1);
		ListNode head2 = reverse(l2);
		ListNode dummy = new ListNode(0);
		ListNode prev = dummy;
		int tag = 0;
		while(head1 != null || head2 != null){
			if(head1 == null){
				if(head2.val + tag == 10){
					prev.next = new ListNode(0);
				}else{
					prev.next = new ListNode((head2.val));
					tag = 0;
				}
				prev = prev.next;
				head2 = head2.next;
			}else if(head2 == null){
				if(head1.val + tag == 10){
					prev.next = new ListNode(0);
				}else{
					prev.next = new ListNode(head1.val);
					tag = 0;
				}
				prev = prev.next;
				head1 = head1.next;
			}else{
				if(head1.val + head2.val + tag >= 10){
					prev.next = new ListNode(head1.val + head2.val + tag - 10);
					tag = 1;
				}else{
					prev.next = new ListNode(head1.val + head2.val + tag);
					tag = 0;
				}
				prev = prev.next;
				head1 = head1.next;
				head2 = head2.next;
			}
		}
		return reverse(dummy.next);
		
	}
	private ListNode reverse(ListNode head){
		if(head == null || head.next == null){
			return head;
		}
		ListNode prev = null;
		while(head != null){
			ListNode temp = head.next;
			head.next = prev;
			prev = head;
			head = temp;
		}
		return prev;
	}
}
