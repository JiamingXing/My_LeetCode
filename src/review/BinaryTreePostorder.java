package review;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//public class BinaryTreePostorder {
//	public List<Integer> inorderTraversal(TreeNode root) {
//		List<Integer> res = new ArrayList<>();
//		helper(root, res);
//		return res;
//	}
//	private void helper(TreeNode root, List<Integer> res) {
//		if (root == null) {
//			return;
//		}
//		helper(root.left, res);
//		helper(root.right, res);
//		res.add(root.val);
//	}
//}

//好好思考下怎么用non-recursive的方式写postorder
public class BinaryTreePostorder {
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();
		TreeNode prev = null;
		TreeNode cur = root;
		if (root == null) {
			return res;
		}
		stack.push(root);
		while (!stack.isEmpty()) {
			cur = stack.peek();
			if (prev == null || prev.left == cur || prev.right == cur) {
				if (cur.left != null) {
					stack.push(cur.left);
				} else if (cur.right != null) {
					stack.push(cur.right);
				}
			} else if (cur.left == prev) {
				if (cur.right != null) {
					stack.push(cur.right);
				}
			} else {
				res.add(cur.val);
				stack.pop();
			}
			prev = cur;
		}
		return res;
	}
}
