package binaryTree;

import java.util.ArrayList;
import java.util.List;

//相比check path sumI  本题要把所有可能路径输出到一个list中
public class checkPathSumII {
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		if(root == null){
			return
		}
		List<List<Integer>> left = new ArrayList<>(pathSum(root.left, sum - root.val));
		List<List<Integer>> right = new ArrayList<>(pathSum(root.right, sum - root.val));
	}
}




/*
public List<List<Integer>> pathSum(TreeNode root, int sum){
	List<List<Integer>> result  = new LinkedList<List<Integer>>();
	List<Integer> currentResult  = new LinkedList<Integer>();
	pathSum(root,sum,currentResult,result);
	return result;
}

public void pathSum(TreeNode root, int sum, List<Integer> currentResult,
		List<List<Integer>> result) {

	if (root == null)
		return;
	currentResult.add(new Integer(root.val));
	if (root.left == null && root.right == null && sum == root.val) {
		result.add(new LinkedList(currentResult));
		currentResult.remove(currentResult.size() - 1);//don't forget to remove the last integer
		return;
	} else {
		pathSum(root.left, sum - root.val, currentResult, result);
		pathSum(root.right, sum - root.val, currentResult, result);
	}
	currentResult.remove(currentResult.size() - 1);
}
*/