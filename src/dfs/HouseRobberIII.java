package dfs;
//和我一开始想法是一样的 但是一开始自己写的时候脑子抽了
//非要写成ResultType 的形式 然后把自己绕晕了
//这样写简单明了 思路是正确的 
public class HouseRobberIII {
	public int rob(TreeNode root) {
		int[] result = helper(root);
		return Math.max(result[0], result[1]);
	}
	public int[] helper(TreeNode root) {
		if (root == null) {
			return new int[2];
		}
		int[] left = helper(root.left);
		int[] right = helper(root.right);
		int[] result = new int[2];
		// 0 means contains this root maximum value
		// 1 means not contains this root maximum value
		result[0] = root.val + left[1] + right[1];
		result[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
		return result;
	}

}
