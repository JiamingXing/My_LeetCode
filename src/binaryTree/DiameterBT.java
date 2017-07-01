package binaryTree;
//用一个全局变量来存储 所有遍历情况的最大值
//当时想的时候总觉得有一种case 是没被考虑进去的
//但是其实用了全局变量 我相当于考虑过了每个节点 不通往上层 但是连接左右的是否是最大值
public class DiameterBT {
	int max = 0;
	public int diameterOfBinaryTree(TreeNode root) {
		helper(root);
		return max;
	}
	public int helper(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int left = helper(root.left);
		int right = helper(root.right);
		max = Math.max(max, left + right);
		return Math.max(left, right) + 1;
	}
}
