package review;

import java.util.ArrayList;
import java.util.List;
//import java.util.Stack;

public class BinaryTreeInorder {
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<>(); 
		helper(root, res);
		return res;
	}
	private void helper(TreeNode root, List<Integer> res) {
		if (root == null) {
			return;
		}
		helper(root.left, res);
		res.add(root.val);
		helper(root.right, res);
	}
}

//non-recursive
//想想这个思路怎么得到的 这个思路还是挺巧妙的
//利用cur = cur.right得到in-order的顺序还是挺不容易想到的
/*
public class BinaryTreeInorder {
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<>(); 
		Stack<TreeNode> stack = new Stack<>();
		TreeNode cur = root;
		while (cur != null || !stack.isEmpty()) {
			while(cur != null) {
				stack.push(cur);
				cur = cur.left;
			}
			cur = stack.pop();
			res.add(cur.val);
			cur = cur.right;
		}
		return res;
	}
}
*/