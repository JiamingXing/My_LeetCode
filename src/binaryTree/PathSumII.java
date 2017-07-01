package binaryTree;

import java.util.ArrayList;
import java.util.List;
//题目意思理解错了必须是 root - leaf
public class PathSumII {
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> temp = new ArrayList<>();
		helper(root, result, temp, sum);
		return result;
	}
	public void helper(TreeNode root, List<List<Integer>> result, 
			List<Integer> temp, int sum) {
		if (root == null) {
			return;
		}
		temp.add(root.val);
		if (root.val == sum) {
			List<Integer> current = new ArrayList<>(temp);
			result.add(current);
		}
		
		helper(root.left, result, temp, sum - root.val);
		helper(root.right, result, temp, sum - root.val);
		temp.remove(temp.size() - 1);
	}

}




//只用一个temp 为什么不行？？？？？？？？？？？？？？？？？？
/*
public class PathSumII {
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> temp = new ArrayList<>();
		helper(root, result, temp, sum);
		return result;
	}
	public void helper(TreeNode root, List<List<Integer>> result, 
			List<Integer> temp, int sum) {
		if (root == null) {
			return;
		}
		temp.add(root.val);
		if (root.val == sum) {
		//这里一开始只用一个temp 不断对temp操作 然后往result里加
		//但是不行为什么？？？ 很关键！！！！
			result.add(temp);
		}
		
		helper(root.left, result, temp, sum - root.val);
		helper(root.right, result, temp, sum - root.val);
		temp.remove(temp.size() - 1);
	}

}
*/
