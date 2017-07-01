package review;

public class ReverseLinkedListII {
	public ListNode reverseBetween(ListNode head, int m, int n) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		head = dummy;
		for (int i = 1; i < m; i ++) {
			if (head != null) {
				head = head.next;
			}
		}
		//第m个点前面的点
		ListNode prev = head;
		//第m个点
		ListNode start = head.next;
		//
		ListNode post = start.next;
		ListNode end = start;
		for (int i = m; i < n; i++) {
			//四步翻转法下一个式子的等号左边是上一个式子的等号右边
			ListNode next = post.next;
			post.next = end;
			end = post;
			post = next;
		}
		start.next = post;
		prev.next = end;
		return dummy.next;
	}
}
