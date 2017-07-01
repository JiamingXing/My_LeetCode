package review;

import java.util.ArrayList;
import java.util.List;
//import java.util.Stack;

//traversal (result int parameter)
public class BinaryTreePreorder {
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		helper(root, res);
		return res;
	}
	private void helper(TreeNode root, List<Integer> res) {
		if (root == null) {
			return;
		}
		res.add(root.val);
		helper(root.left, res);
		helper(root.right, res);
	}
}

//divide and conquer(result in return value)
/*
public class BinaryTreePreorder {
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		if (root == null) {
			return res;
		}
		res.add(root.val);
		List<Integer> left = preoderTraversal(root.left);
		List<Integer> right = preorderTraversal(root.right);
		res.addAll(left);
		res.addAll(right);
		return res;
	}
}
*/

//non-recursive
/*
public class BinaryTreePreorder {
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();
		if (root == null) {
			return res;
		}
		stack.push(root);
		while(!stack.isEmpty()) {
			TreeNode node = stack.pop();
			res.add(node.val);
			if (node.right != null) {
				stack.push(node.right);
			}
			if (node.left != null) {
				stack.push(node.left);
			}
		}
		return res;
	}
}
*/