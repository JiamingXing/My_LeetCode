package dfs;


public class ConvertSortedListToBST {
	private class ResultType {
		ListNode prev;
		ListNode mid;
		ResultType (ListNode prev, ListNode mid) {
			this.prev = prev;
			this.mid = mid;
		}
	}
	public TreeNode sortedListToBST(ListNode head) {
		if (head == null) {
			return null;
		}
		if (head.next == null) {
			return new TreeNode(head.val);
		}
		//如果这样判断[1,3]只有两个node的情况 会超时
//		if (head.next.next == null) {
//		    TreeNode root = new TreeNode(head.val);
//		    root.right = new TreeNode(head.next.val);
//		    root.left = null;
//		    return root;
//		}
		ResultType temp = findMiddle(head);
		TreeNode root = new TreeNode(temp.mid.val);
		TreeNode right = sortedListToBST(temp.mid.next);
		if (temp.mid == temp.prev) {
			root.left = null;
			root.right = right;
			return root;
		} else {
			temp.prev.next = null;
			TreeNode left = sortedListToBST(head);
			root.left = left;
			root.right = right;
			return root;
		}
	}
	public ResultType findMiddle(ListNode head) {
		ListNode slow = head;
		ListNode fast = head.next;
		ListNode prev = head;
		 while(fast != null && fast.next != null){
			 fast = fast.next.next;
			 prev = slow;
			 slow = slow.next;
		 }
		 return new ResultType(prev, slow);
	}

}
