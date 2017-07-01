package review;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class BTRightSideView {
	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		helper(root, res, 1);
		return res;
	}
	private void helper(TreeNode root, List<Integer> res, int depth) {
		if (root == null) {
			return;
		}
		if (res.size() < depth) {
			res.add(root.val);
		}
		helper(root.right, res, depth+1);
		helper(root.left, res, depth+1);
	}
}

/*
//BFS实在是太慢了
public class BTRightSideView {
	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		if (root == null) {
			return res;
		}
		Stack<TreeNode> stack = new Stack<>();
		Queue<TreeNode> Q = new LinkedList<>();
		Q.add(root);
		while(!Q.isEmpty()) {
			int size = Q.size();
			for (int i = 0; i < size; i++) {
				TreeNode node = Q.poll();
				stack.push(node);
				if (node.left != null) {
					Q.add(node.left);
				}
				if (node.right != null) {
					Q.add(node.right);
				}
			}
			res.add(stack.peek().val);
		}
		return res;
	}
}
*/
