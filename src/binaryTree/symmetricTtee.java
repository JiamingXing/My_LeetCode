package binaryTree;
//这道题不是自己想出来的 好好体会
public class symmetricTtee {
	public boolean isSymmetric(TreeNode root) {
		if(root == null){
			return true;
		}
		return isSymmetricSubtree(root.left, root.right);
	}
	public boolean isSymmetricSubtree(TreeNode left, TreeNode right){
		if(left == null && right == null){
			return true;
		}
		if(left == null || right == null){
			return false;
		}
		if(left.val == right.val){
			return isSymmetricSubtree(left.left, right.right) && isSymmetricSubtree(left.right, right.left);
		}
		else{
			return false;
		}
	}

}
