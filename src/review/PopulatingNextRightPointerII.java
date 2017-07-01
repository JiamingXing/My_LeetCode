package review;

public class PopulatingNextRightPointerII {
	public void connect(TreeLinkNode root) {
		TreeLinkNode head = root;
		TreeLinkNode cur = null;
		TreeLinkNode prev = null;
		while (head != null) {
			cur = head;
			prev = null;
			head = null;
			while (cur != null) {
				if (cur.left != null) {
					if (prev != null) {
						prev.next = cur.left;
					} else {
						head = cur.left;
					}
					prev = cur.left;
				}
				if (cur.right != null) {
					if (prev != null) {
						prev.next = cur.right;
					} else {
						head = cur.right;
					}
					prev = cur.right;
				}
				cur = cur.next;
			}
		}
	}
}
