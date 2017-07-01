package review;
//我需要两个元素来进行判断balanced
//高度和子树是否balanced

public class BalancedBT {
	private class ResultType {
		int height;
		boolean balanced;
		public ResultType(int height, boolean balanced) {
			this.height = height;
			this.balanced = balanced;
		}
	}
	public boolean isBalanced(TreeNode root) {
		ResultType res = helper(root);
		return res.balanced;
	}
	private ResultType helper(TreeNode root) {
		if (root == null) {
			return new ResultType(0, true);
		}
		ResultType left = helper(root.left);
		ResultType right = helper(root.right);
		if (!left.balanced || !right.balanced) {
			return new ResultType(-1, false);
		}
		if (left.height == right.height || Math.abs(left.height - right.height) == 1) {
			return new ResultType(Math.max(left.height, right.height) + 1, true);
		}
		return new ResultType(-1, false);
	}
}



/*
public class BalancedBT {
	public boolean isBalanced(TreeNode root) {
		if(root == null) {
			return true;
		}
		int left = maxDepth(root.left);
		int right = maxDepth(root.right);
		if (left == right || Math.abs(left - right) == 1) {
			if (isBalanced(root.left) && isBalanced(root.right)) {
				return true;
			}
		}
		return false;
	}
	private int maxDepth (TreeNode root) {
		if (root == null) {
			return 0;
		}
		int left = maxDepth(root.left);
		int right = maxDepth(root.right);
		return Math.max(left, right) + 1;
	}
}
*/
