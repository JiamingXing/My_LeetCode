package binaryTree;
/*
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// T(n) = 2T(n/2) + O(1) : T(n) = O(n)
public class maxDepthBT{
	public int maxDepth(TreeNode root) {
		if(root == null){
			return 0;
		}
		int left = maxDepth(root.left);
		int right = maxDepth(root.right);
		return Math.max(left, right) + 1;
	}
	
}
/*
public class maxDepthBT {
	//这样的程序不好，很难被线程化，现在还不是很理解为什么？
	private int depth;
	public int maxDepth(TreeNode root) {
		//先initialize depth
		depth = 0;
		helper(root, 1);
		return depth;
	}
	private void helper(TreeNode node, int currentDepth){
		if(node == null){
			return;
		}
		if(currentDepth > depth){
			depth = currentDepth;
		}
		helper(node.left, depth + 1);
		helper(node.right, depth + 1);
	}
*/
//按照以前的思路，考虑tree的问题，思考整棵树的深度和左右子树的深度游什么关系？
//想好之后就可以用divide & conquer的思路写
// depth = max(depth.left, depth.right) + 1;
		
		 



