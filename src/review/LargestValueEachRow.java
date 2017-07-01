package review;
//本质上和level-order traversal一样所以想一想那道题的几种思路
// one queue, two queues, one queue + dummy node, BFS by DFS
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// DFS 加一个level tag
//
public class LargestValueEachRow {
	public List<Integer> largestValues(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		dfs(root, res, 0);
		return res;
	}
	private void dfs(TreeNode root, List<Integer> res, int level) {
		if (root == null) {
			return;
		}
		if (level == res.size()) {
			res.add(root.val);
		} else {
			res.set(level, Math.max(res.get(level), root.val));
		}
		dfs(root.left, res, level+1);
		dfs(root.right, res, level+1);
	}

}

// one queue
/*
public class LargestValueEachRow {
	public List<Integer> largestValues(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		Queue<TreeNode> Q = new LinkedList<>();
		if (root == null) {
			return res;
		}
		Q.add(root);
		while (!Q.isEmpty()) {
			int max = Integer.MIN_VALUE;
			int size = Q.size();
			for (int i = 0; i < size; i++) {
				TreeNode node = Q.poll();
				max = Math.max(max, node.val);
				if (node.left != null) {
					Q.add(node.left);
				}
				if (node.right != null) {
					Q.add(node.right);
				}
			}
			res.add(max);
		}
		return res;
	}

}
*/

/*
 * one queue + dummy node
public class LargestValueEachRow {
	public List<Integer> largestValues(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		Queue<TreeNode> Q = new LinkedList<>();
		if (root == null) {
			return res;
		}
		Q.add(root);
		TreeNode dummy = null;
		Q.add(dummy);
		int max = Integer.MIN_VALUE;
		while(!Q.isEmpty()) {
			TreeNode node = Q.poll();
			if (node == null) {
				res.add(max);
				max = Integer.MIN_VALUE;
				//一开始没有想到判断是不是空 无脑加dummy会出现死循环
				if (!Q.isEmpty()) {
					Q.add(dummy);
				}
				continue;
			}
			max = Math.max(max, node.val);
			if (node.left != null) {
				Q.add(node.left);
			}
			if (node.right != null) {
				Q.add(node.right);
			}
		}
		return res;
	}

}
*/
