package review;


public class ConvertSortedListToBST {
	public TreeNode sortedListToBST(ListNode head) {
		if (head == null) {
			return null;
		}
		if (head.next == null) {
			return new TreeNode(head.val);
		}
		ListNode fast = head.next;
		ListNode slow = head;
		ListNode firstHalf = head;
		while (fast != null && fast.next != null) {
			firstHalf = slow;
			slow = slow.next;
			fast = fast.next.next;
		}
		//设置一个prev断开变成新的linked list代码写起来就会简洁
		//不需要考虑边界条件
		firstHalf.next = null;
		TreeNode root = new TreeNode(slow.val);
		root.left = sortedListToBST(head);
		root.right = sortedListToBST(slow.next);
		return root;
	}
}

//自己写的正确版本
/*
public class ConvertSortedListToBST {
	public class ResultType {
		ListNode middle;
		ListNode prev;
		public ResultType (ListNode middle, ListNode prev) {
			this.middle = middle;
			this.prev = prev;
		}
	}
	public TreeNode sortedListToBST(ListNode head) {
		if (head == null) {
			return null;
		}
		if (head.next == null) {
			return new TreeNode(head.val);
		}
		ResultType mid = findMiddle(head);
		ListNode right = mid.middle.next;
		mid.prev.next = null;
		TreeNode root = new TreeNode(mid.middle.val);
		//如果list只有两个点的话 会出现prev和slow重合的情况
		if (mid.middle == mid.prev) {
			root.left = null;
			root.right = sortedListToBST(right);
			return root;
		} else {
			root.left = sortedListToBST(head);
			root.right = sortedListToBST(right);
			return root;
		}
	}
	private ResultType findMiddle(ListNode head) {
		ListNode prev = head;
		ListNode slow = head;
		ListNode fast = head.next;
		while (fast != null && fast.next != null) {
			prev = slow;
			slow = slow.next;
			fast = fast.next.next;
		}
		return new ResultType(slow, prev);
	}
}
*/

//别人写的简洁版本
/*
public class Solution {
public TreeNode sortedListToBST(ListNode head) {
    if(head==null) return null;
    return toBST(head,null);
}
public TreeNode toBST(ListNode head, ListNode tail){
    ListNode slow = head;
    ListNode fast = head;
    if(head==tail) return null;
    
    while(fast!=tail&&fast.next!=tail){
        fast = fast.next.next;
        slow = slow.next;
    }
    TreeNode thead = new TreeNode(slow.val);
    thead.left = toBST(head,slow);
    thead.right = toBST(slow.next,tail);
    return thead;
}
*/
