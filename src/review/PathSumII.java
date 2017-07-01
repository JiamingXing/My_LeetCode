package review;

import java.util.ArrayList;
import java.util.List;
//错误版本！！！！！
public class PathSumII {
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> temp = new ArrayList<>();
		helper(root, res, temp, sum);
		return res;
	}
	private void helper(TreeNode root, List<List<Integer>> res, List<Integer> temp, int sum) {
		if (root == null) {
			return;
		}
		temp.add(root.val);
		if (root.left == null && root.right == null) {
			if (root.val == sum) {
				res.add(new ArrayList<>(temp));
			}
		}
		helper(root.left, res, temp, sum - root.val);
		//调用两次temp 两个temp的内容是一样的？
		//先left 一直递归到底
		//自己脑子进水了。。
		helper(root.right, res, temp, sum - root.val);
		temp.remove(temp.size() - 1);
	}
}

//正确版本
/*
public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
		List<Integer> temp = new ArrayList<>();
		helper(root, res, temp, sum);
		return res;
    }
    private void helper(TreeNode root, List<List<Integer>> res, List<Integer> temp, int sum) {
		if (root == null) {
			return;
		}
		temp.add(root.val);
		if (root.left == null && root.right == null && root.val == sum) {
            res.add(new ArrayList<>(temp));
		}
		helper(root.left, res, temp, sum - root.val);
		helper(root.right, res, temp, sum - root.val);
		temp.remove(temp.size() - 1);
	}
}
*/
