package binaryTree;

import java.util.ArrayList;
import java.util.List;
//这道题很关键的一点加了一个depth参数。。。。。比较tricky
//自己的思路就是右边不空helper(右),在判断左边，都空直接返回，会漏掉一些情况

public class rightSideViewBT {
	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		helper(root, result, 0);
		return result;
	}
	public void helper(TreeNode root, List<Integer> result, int depth){
		if(root == null){
			return;
		}
		if(depth == result.size()){
			result.add(root.val);
		}
		helper(root.right, result, depth + 1);
		helper(root.left, result, depth + 1);
	}

}
