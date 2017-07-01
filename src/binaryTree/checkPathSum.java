package binaryTree;

public class checkPathSum {
	public boolean hasPathSum(TreeNode root, int sum) {
		if(root == null){
			return false;
		}
		if(root.left == null && root.right == null && sum - root.val == 0){
			return true;
		}
		return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
	}

}
//一开始自己写的思路是错的 看看递归的思路有社么不同
//题目要求root-to-leaf 必须到leaf的path才算
//而且比如一些特殊情况空的树sum = 0 的情况也会有问题
/*
public boolean hasPathSum(TreeNode root, int sum) {
	if(sum == 0){
    	return true;
	}
	if(root == null){
    	return false;
	}

	boolean left = hasPathSum(root.left, sum - root.val);
	boolean right = hasPathSum(root.right, sum- root.val);
	if(left || right){
    	return true;
	}else{
    	return false;
	}
}
*/