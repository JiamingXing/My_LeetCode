package linkedList;
//做list的题先画图很重要
public class ReverseNodesKGroup {
	public ListNode reverseKGroup(ListNode head, int k) {
		if(head == null || head.next == null || k == 0 || k == 1){
			return head;
		}
		ListNode dummy = new ListNode(0);
		dummy.next = head;
	}

}
