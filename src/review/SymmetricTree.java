package review;
//这道题值得思考
//因为我当前的结果应该是和下两层的children的关系有关
//能不能找到left.left 和 right.right的关系
public class SymmetricTree {
	public boolean isSymmetric(TreeNode root) {
		if (root == null) {
			return true;
		}
		return helper(root.left, root.right);
	}
	private boolean helper(TreeNode left, TreeNode right) {
		if (left == null && right == null) {
			return true;
		}
		if (left == null || right == null) {
			return false;
		}
		if (left.val == right.val) {
			return helper(left.left, right.right) && helper(left.right, right.left);
		}
		return false;
	}
}
