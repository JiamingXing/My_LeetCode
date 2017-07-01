package binaryTree;

import java.util.ArrayList;
import java.util.List;

// in order: left root right
//consider recursive solution first
//but is's trivial, do it iteratively?
//这道题递归是自己独立想出来的 再重新思考下心路历程！
public class inOrderBT {
	 public List<Integer> inorderTraversal(TreeNode root) {
		 List<Integer> result = new ArrayList<>();
		 helper(root, result);
		 return result;
		 
	 }
	 public void helper(TreeNode root, List<Integer> result){
		 if(root == null){
			 return;
		 }
		 helper(root.left, result);
		 result.add(root.val);
		 helper(root.right, result);
//		 List<Integer> left = helper(root.left);
//		 List<Integer> right = helper(root.right);
//		 result.addAll(left);
//		 result.add(root.val);
//		 result.addAll(right);
	 }

}
//could u do it iteratively?
//Morris traversal O(1) extra space and O(n) time complexity


/*
private void inorder(TreeNode root) {
    TreeNode node = root;
    while (node != null) {
        if (node.left == null) {
            handleValue(node.val);
            node = node.right;
        } else {
            TreeNode prev = node.left;
            while (prev.right != null && prev.right != node)
                prev = prev.right;
            if (prev.right == null) {
                prev.right = node;
                node = node.left;
            } else {
                prev.right = null;
                handleValue(node.val);
                node = node.right;
            }
        }
    }
}
*/

