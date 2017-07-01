package review;
//do it in O(n) time and O(1) space
public class PalindromeLinkedList {
	public boolean isPalindrome(ListNode head) {
		if (head == null || head.next == null) {
			return true;
		}
		ListNode middle = findMiddle(head);
		ListNode head2 = reverse(middle.next);
		middle.next = null;
		while (head2 != null && head != null) {
			if (head2.val != head.val) {
				return false;
			}
			head2 = head2.next;
			head = head.next;
		}
		return true;
	}
	private ListNode findMiddle(ListNode head) {
		ListNode slow = head;
		ListNode fast = head.next;
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		return slow;
	}
	private ListNode reverse(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode prev = null;
		while (head != null) {
			ListNode next = head.next;
			head.next = prev;
			prev = head;
			head = next;
		}
		return prev;
	}
}
