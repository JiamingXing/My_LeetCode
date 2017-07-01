package review;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//这样为什么不行？
public class MFSS {
	int max;
	public int[] findFrequentTreeSum(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		max = 0;
		Map<Integer, Integer> map = new HashMap<>();
		helper(root, map);
		for (int key : map.keySet()) {
			if (map.get(key) == max) {
				res.add(key);
			}
		}
		int[] result = new int[res.size()];
		for (int i = 0; i < res.size(); i++) {
			result[i] = res.get(i);
		}
		return result;
	}
	private int helper(TreeNode root, Map<Integer, Integer>) {
		if (root == null) {
			return 0;
		}
		int left = helper(root.left, map);
		int right = helper(root.right, map);
		int temp = left + right + root.val;
		map.put(temp, map.getOrDefault(temp, 0) + 1);
		max = Math.max(max, map.get(temp));
		return temp;
	}
}

/*
public class MFSS {
	int max;
	Map<Integer, Integer> map;
	public int[] findFrequentTreeSum(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		max = 0;
		map = new HashMap<>();
		helper(root);
		for (int key : map.keySet()) {
			if (map.get(key) == max) {
				res.add(key);
			}
		}
		int[] result = new int[res.size()];
		for (int i = 0; i < res.size(); i++) {
			result[i] = res.get(i);
		}
		return result;
	}
	private int helper(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int left = helper(root.left);
		int right = helper(root.right);
		int temp = left + right + root.val;
		map.put(temp, map.getOrDefault(temp, 0) + 1);
		max = Math.max(max, map.get(temp));
		return temp;
	}
}
*/
