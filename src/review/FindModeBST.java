package review;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/*
public class FindModeBST {
	int count = 0;
	int max = 0;
	Integer prev = null;
	public int[] findMode(TreeNode root) {
		List<Integer> temp = new ArrayList<>();
		helper(root, temp);
		int[] res = new int[temp.size()];
		for(int i = 0; i < res.length; i++) {
			res[i] = temp.get(i);
		}
		return res;
	}
	private void helper(TreeNode root, List<Integer> temp) {
		if (root == null){
			return;
		}
		helper(root.left, temp);
		if (prev != null) {
			if (root.val == prev) {
				count ++;
			} else {
				count = 1;
			}
		}
		if (count > max) {
			max = count;
			temp.clear();
			temp.add(root.val);
		} else if (count == max) {
			temp.add(root.val);
		}
		prev = root.val;
		helper(root.right, temp);
 	}
}
*/


public class FindModeBST {
	Map<Integer, Integer> map;
	int max = 0;
	public int[] findMode(TreeNode root) {
		map = new HashMap<>();
		List<Integer> temp = new ArrayList<>();
		helper(root);
		for (int key : map.keySet()) {
			if (map.get(key) == max) {
				temp.add(key);
			}
		}
		int[] res = new int[temp.size()];
		for (int i = 0; i < res.length; i++) {
			res[i] = temp.get(i);
		}
		return res;
	}
	private void helper(TreeNode root) {
		if (root == null) {
			return;
		}
		map.put(root.val, map.getOrDefault(root.val, 0)+1);
		max = Math.max(max, map.get(root.val));
		helper(root.left);
		helper(root.right);
	}
}
