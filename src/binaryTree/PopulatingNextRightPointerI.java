package binaryTree;
//all next pointer are intialized to null
//assume it is a perfect binary tree
public class PopulatingNextRightPointerI {
	public void connect(TreeLinkNode root) {
		TreeLinkNode levelStart = root;
		while (levelStart != null) {
			TreeLinkNode cur = levelStart;
			while (cur != null) {
				if (cur.left != null) {
					cur.left.next = cur.right;
				}
				if (cur.right != null && cur.next != null) {
					cur.right.next = cur.next.left;
				}
				cur = cur.next;
			}
			levelStart = levelStart.left;
		}
	}

}
