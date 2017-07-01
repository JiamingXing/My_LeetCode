package review;

public class HouseRobberIII {
	public int rob(TreeNode root) {
		int[] result = helper(root);
		return Math.max(result[0], result[1]);
	}
	private int[] helper(TreeNode root) {
		if (root == null) {
			return new int[2];
		}
		int[] left = helper(root.left);
		int[] right = helper(root.right);
		int[] res = new int[2];
		res[0] = root.val + left[1] + right[1];
		res[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
		return res;
	}
}
