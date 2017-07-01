package binaryTree;

import java.util.ArrayList;
import java.util.List;

public class FindModeBST {
	int max = 0;
	List<List<Integer>> result = new ArrayList<>();
	public int[] findMode(TreeNode root) {
		if (root == null) {
            return new int[0];
        }
		helper(root);
		int length = result.get(result.size()-1).size();
		int[] res = new int[length];
		for (int i = 0; i < length; i++) {
			res[i] = result.get(result.size()-1).get(i);
		}
		return res;
	}
	public int helper(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int temp = 1;
		int left = helper(root.left);
		int right = helper(root.right);
		if (left != 0 && root.val == root.left.val) {
			temp += left;
		}
		if (right != 0 && root.val == root.right.val) {
			temp += right;
		}
		if (temp > max) {
			max = temp;
			List<Integer> list = new ArrayList<>();
			list.add(root.val);
			result.add(list);
		} else if (temp == max) {
			result.get(result.size() - 1).add(root.val);
		}
		return temp;
	}
}
