package review;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
//这道题思路是正确的但是这样的写法是错误的！！！！
//问题出在 max 和 map 应该作为全局变量  而且不应该用在 helper的参数中 
//那么用在里面为什么不可以？
//到底什么是全局变量  和instance variable  和field一样吗？
//为什么尽量不要使用全局变量 但是什么时候需要用到全局变量
//我没有改这道题的写法 下面就是我在review的时候写的错误代码 以此借鉴！！！ 
public class MostFrequentSubtreeSum {
	public int[] findFrequentTreeSum(TreeNode root) {
		Map<Integer, Integer> map = new HashMap<>();
		int max = 0;
		helper(root, map, max);
		ArrayList<Integer> list = new ArrayList<>();
		for (int key : map.keySet()) {
			if (map.get(key) == max) {
				list.add(key);
			}
		}
		int[] result = new int[list.size()];
		for (int i = 0; i < list.size(); i ++) {
			result[i] = list.get(i);
		}
		return result;
	}
	private int helper(TreeNode root, Map<Integer, Integer> map, int max) {
		if (root == null) {
			return 0;
		}
		int left = helper(root.left, map, max);
		int right = helper(root.right, map, max);
		int res = left + right + root.val;
		map.put(res, map.getOrDefault(res, 0) + 1);
		max = Math.max(max, map.get(res));
		return res;
	}

}
