package review;

import java.util.LinkedList;
import java.util.Queue;
//BFS从右到左入队，最后一个节点就是答案
public class FindBotLeftTreeVal {
	public int findBottomLeftValue(TreeNode root) {
		Queue<TreeNode> Q = new LinkedList<>();
		Q.add(root);
		TreeNode node = null;
		while(!Q.isEmpty()) {
			node = Q.poll();
			if (node.right != null) {
				Q.add(node.right);
			}
			if (node.left != null) {
				Q.add(node.left);
			}
		}
		return node.val;
	}
}

// 同样可以考虑BFS和DFS两种思路 因为要一层层的找第一反应想到的肯定是BFS
// 但是会比较慢
// global variable
// 第一次出现 h < level的时候更新result
/*
public class FindBotLeftTreeVal {
	int res;
	int h;
	public int findBottomLeftValue(TreeNode root) {
		res = 0;
		dfs(root, 1);
		return res;
	}
	private void dfs(TreeNode root, int level) {
		if (h < level) {
			res = root.val;
			h = level;
		}
		if (root.left != null) {
			dfs(root.left, level+1);
		}
		if (root.right != null) {
			dfs(root.right, level+1);
		}
	}
}
*/

/*
// no gloval variable DFS
public class Solution {
    public int findBottomLeftValue(TreeNode root) {
    	int[] ar = new int[]{0,0};
        findBottomLeftValue(root, 1, ar);
        return ar[0];
    }
    public void findBottomLeftValue(TreeNode root, int depth, int[] res) {
        if (res[1]<depth) {
        	res[0]=root.val;
        	res[1]=depth;
        }
        if (root.left!=null) {
        	findBottomLeftValue(root.left, depth+1, res);
        }
        if (root.right!=null) {
        	findBottomLeftValue(root.right, depth+1, res);
        }
    }
}
*/
