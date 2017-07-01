package linkedList;
// O(n) time and O(1) space
//这道题根据结合之前find middle 和 reverse的经验自己做出来了
//但是做题过程中 需要对next或者当前节点判断是否为空的条件判断还是狠模糊
//再用心体会一下
public class PalindromeLinkedList {
	public boolean isPalindrome(ListNode head){
		if(head == null || head.next == null){
			return true;
		}
		ListNode middle = findMiddle(head);
		//separate list into two part to judge whether it is palindrome
		ListNode head1 = head;
		ListNode head2 = middle.next;
		middle.next = null;
//		ListNode prev = null;
		//reverse the second half of the list
		//这一段可以函数化
//		while(head2 != null){
//			ListNode temp = head2.next;
//			head2.next = prev;
//			prev = head2;
//			head2 = temp;
//		}
//		head2 = prev;
		head2 = reverse(head2);
		while(head1 != null && head2 != null){
			if(head1.val == head2.val){
				head1 = head1.next;
				head2 = head2.next;
			}else{
				return false;
			}
		}
		return true;
		
		
	}
	private ListNode findMiddle(ListNode head){
		ListNode slow = head;
		ListNode fast = head.next;
		
		while(fast != null && fast.next != null){
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
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
