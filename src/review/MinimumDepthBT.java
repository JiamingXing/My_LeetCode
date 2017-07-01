package review;

import binaryTree.TreeNode;

public class MinimumDepthBT {
	public int minDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		if (root.left == null && root.right == null) {
			return 1;
		}
		//这样的写法不对 会超时 这是为什么？
		//这是review所以第一遍做题需要注意的点并没有掌握
		int left = minDepth(root.left);
		int right = minDepth(root.right);
		left = left == 0? Integer.MAX_VALUE : left;
		right = right == 0 ? Integer.MAX_VALUE : right;
		return Math.min(left, right) + 1;
	}
}
/*
public class minDepthBT {
	public int minDepth(TreeNode root) {
		 if(root == null){
			 return 0;
		 }
		 int left = minDepth(root.left);
		 int right = minDepth(root.right);
	        
		 if(left == 0 || right == 0){
			 return left + right + 1;
		 }else{
			 return Math.min(left, right) + 1;
		 }
	}

}
*/
