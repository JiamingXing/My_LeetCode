package binaryTree;
// different with the btMaxPathSum 
// this maximum sum is from root and the path may end at any root
// root to any
public class btMaximumPathSumII {
	public int maxPathSumII(TreeNode root) {
		if(root == null){
			return Integer.MIN_VALUE; // Integer.MIN_VALUE 无解
		}
		
		//divide
		int left = maxPathSumII(root.left);
		int right = maxPathSumII(root.right);
		
		//conquer
		// return Math.max(left,right) + root.val
		//这样返回到leaf的最长路径了 不是any node
		return Math.max(Math.max(left,right), 0) + root.val;
	}

}
