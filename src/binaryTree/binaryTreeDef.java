package binaryTree;
// 90% Binary Tree problem 属于 Divide Conquer!!!!!
// Given a binary tree, return the preorder traversal of its node's values;
// divide and conquer 比 recursion 时间复杂度高一些
//碰到二叉树的问题，就想一想整颗树在这个问题上的结果和左右儿子在这个问题上的结果有什么联系？
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


/*
 Definition for binary tree
 public class TreeNode{
 	int val;
 	TreeNode left;
 	TreeNode right;
 	TreeNode(int x){Val = x;}
 }
 */

//对于preorder root left right的顺序 
//对于stack结构 先进后出所以先放right

public class binaryTreeDef {
	public List<Integer> preorderTraversal(TreeNode root){
		Stack<TreeNode> stack = new Stack<TreeNode>();
		List<Integer> preorder = new ArrayList<>();
		if(root == null){
			return preorder;
		}
		stack.push(root);
		while(!stack.empty()){
			TreeNode node = stack.pop();
			preorder.add(node.val);
			if(node.right != null){
				stack.push(node.right);
			}
			if(node.left != null){
				stack.push(node.left);
			}
		}
		return preorder;
	}

}


/*
//Version 1: Traverse
//Top down
public class solution{
	public ArrayList<Integer> preorderTraversal(TreeNode root){
		ArrayList<Integer> result = new ArrayList<>();
		traverse(root, result);
		return result;
	}
	private void traverse(TreeNode root, ArrayList<Integer> result){
		if(root == null){
			return;
		}
		result.add(root.val);
		traverse(root.left, result);
		traverse(root.right, result);
	}
}

// Version 2： Divide & Conquer
// Bottom up 
public class solution{
	public ArrayList<Intger> preorderTraversal(TreeNode root){
		ArrayList<Integer> result = new ArrayList<>();
		if(root == null){
			return result;
		}
		
		// divide
		ArrayList<Integer> left = new ArrayList<>();
		ArrayList<Integer> right = new ArrayList<>();
		// conquer
		result.add(root.val);
		result.addAll(left);
		result.addAll(right);
		return result;
	}
}
*/


