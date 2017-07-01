package hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import binaryTree.TreeNode;

public class MostFrequentSubtreeSum {
	//什么时候需要用到全局变量 虽然尽量不要使用？！
	int count;
	Map<Integer, Integer> map;
	public int[] findFrequentTreeSum(TreeNode root) {
		count = 0;
		map = new HashMap<>();
		helper(root);
		List<Integer> list = new ArrayList<>();
		for (int n : map.keySet()) {
			if (map.get(n) == count) {
				list.add(n);
			}
		}
		int[] result = new int[list.size()];
		for (int i = 0; i < result.length; i++) {
			result[i] = list.get(i);
		}
		return result;
	}
	public int helper(TreeNode root) {
		if(root == null) {
			return 0;
		}
		int left = helper(root.left);
		int right = helper(root.right);
		int sum = left + right + root.val;
		if (map.containsKey(sum)) {
			map.put(sum, map.get(sum) + 1);
			count = Math.max(count, map.get(sum));
		} else {
			map.put(sum, 1);
			count = Math.max(count, 1);
		}
		return sum;
	}

}
//这道题的思路很简单 因为求每一个node的subtreeSum 很容易
//所以把对应的所有的subtreeSum 和 他的count 放入 hashmap中也很容易
//遇到的问题是如何遍历这个map 把频率最高的sum输出
//用到了我不熟悉的方法 map.keySet(); 
//这个方法返回了一个set 我可以遍历set中的所有元素 也就是所有的key
//当时自己思考这个问题的时候 还纠结了我用DFS遍历树来写helper的时候
//helper的函数类型是要 用int 还是void 还是写一个resultType？
//还有就是map我是作为全局变量还是作为helper函数的local variable？
