package binaryTree;

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
//这道题一开始用了最直接的思路，但是是错的，出现了没有通过的case
//没有把是不是leaf节点分开考虑 那么tree：[1 2]无法通过
//比如某一个节点rightsubtree是空 但是leftsubtree不空 按照这样的做法
//高度会出错，用left == 0 || right == 0 避免了这种情况，需要学会这种方法
//这是他和maxdepth唯一的区别。

/*
int left = minDepth(root.left);
int right = minDepth(root.right);
return Math.min(left, right) + 1;
*/