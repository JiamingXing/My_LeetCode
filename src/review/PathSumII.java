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


//复习的时候写的没有AC的版本
/*
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        helper(res, temp, root, sum);
        return res;
    }
    private void helper(List<List<Integer>> res, List<Integer> temp, TreeNode root, int target) {
        if (root == null) {
            return;
        }
        temp.add(root.val);
        if (root.left == null && root.right == null) {
            if (root.val == target) {
                res.add(new ArrayList<>(temp));
                //错在这个地方这个地方千万不能加return 因为就算我成功加到res中
                 //我还是要remove掉当前temp上的元素来做之后的循环
                return;
            }
        }
        helper(res, temp, root.left, target - root.val);
        helper(res, temp, root.right, target - root.val);
        temp.remove(temp.size() - 1);
    }
}
*/



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
