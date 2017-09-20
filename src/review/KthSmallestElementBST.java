package review;

import java.util.Stack;

// dfs
/*
public class KthSmallestElementBST {
	public int kthSmallest(TreeNode root, int k) {
	int temp = count(root.left);
		if (k <= temp) {
			return kthSmallest(root.left, k);
		} else if (k > temp + 1) {
			return kthSmallest(root.right, k-temp-1);
		}
		return root.val;
	}
	public int count(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int left = count(root.left);
		int right = count(root.right);
		return left + right + 1;
	}
}
*/
//version2 : inorder-traversal : sorted array get K th element
public class KthSmallestElementBST {
	public int kthSmallest(TreeNode root, int k) {
		Stack<TreeNode> stack = new Stack<>();
		TreeNode cur = root;
		while (cur != null) {
			stack.push(cur);
			cur = cur.left;
		}
		while (k != 0) {
			TreeNode node = stack.pop();
			k --;
			if (k == 0) {
				return node.val;
			}
			TreeNode right = node.right;
			while (right != null) {
				stack.push(right);
				right = right.left;
			}
		}
		return -1;
	}
}
