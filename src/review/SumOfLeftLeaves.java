package review;
//用全局变量速度会慢很多
public class SumOfLeftLeaves {
	public int sumOfLeftLeaves(TreeNode root) {
		int sum = 0;
		if (root == null) {
			return sum;
		}
		if (root.left != null) {
			if (root.left.left == null && root.left.right == null) {
				sum += root.left.val;
			} else {
				sum += sumOfLeftLeaves(root.left);
			}
		}
		sum += sumOfLeftLeaves(root.right);
		return sum;
	}
}

/*
public class SumOfLeftLeaves {
	int sum;
	public int sumOfLeftLeaves(TreeNode root) {
		helper(root);
		return sum;
	}
	private void helper(TreeNode root) {
		if (root == null) {
			return;
		}
		if (root.left != null && root.left.left == null && root.left.right == null) {
			sum += root.left.val;
		}
		helper(root.left);
		helper(root.right);
	}
}
*/
