package binaryTree;

import java.util.ArrayList;
import java.util.List;

//find all root to leaf paths
//DFS
//如何判断是不是leaf，递归一直到leaf就完成一个String的操作，然后加到List中
//这道题 主要是对String的操作不熟悉 会有麻烦。。
//思路因为他只返回一个List 那么不用非递归 你不知道要加多少个String temp进去
//所以需要用递归来做
//但是好像这么做的时间复杂度很高。。
public class pathsBT {
	public List<String> binaryTreePaths(TreeNode root) {
		List<String> result = new ArrayList<>();
		if(root != null){
			helper(root, result, "");
		}
		return result;
	}
	public void helper(TreeNode root, List<String> result, String path){
		if(root.left == null && root.right == null){
			result.add(path + root.val);
		}
		if(root.left != null){
			helper(root.left, result, path + root.val + "->");
		}
		if(root.right != null){
			helper(root.right, result, path + root.val + "->");
		}
	}

}
/*
 //首先这道题用的是String concatenation的方法，too costly
 The time complexity of this method  should be O(n), since we are 
 basically visit each node in the tree. Yet an interviewer may ask
 u for further optimization. A StringBulder can be used although a bit
 tricky since it is not immutable like string is.
 
  When using StringBuilder, We can just keep track of the length of the
  StringBuilder before we append anything to recursion and afterwards.
  set the length back. Another tricky is when to append the "->", since
  we don't need the last arrow at the end of the string. We only append
  it before recurse to the next level of the tree. 
 */

/*
 public List<String> binaryTreePaths(TreeNode root){
 	List<String> res = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    helper(res, root, sb);
    return res;
 }
 private void helper(List<String> res, TreeNode root, StringBuilder sb){
 	if(root == null) {
        return;
    }
	int len = sb.length();
	sb.append(root.val);
	if(root.left == null && root.right == null) {
	res.add(sb.toString());
	} else {
	sb.append("->");
	helper(res, root.left, sb);
	helper(res, root.right, sb);
	}
	//如果不加这一句setlength会怎样？
	sb.setLength(len);
 }
 */
