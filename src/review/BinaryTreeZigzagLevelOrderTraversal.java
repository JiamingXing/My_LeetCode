package review;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
//思路没问题但是速度有点慢
public class BinaryTreeZigzagLevelOrderTraversal {
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		Queue<TreeNode> Q = new LinkedList<>();
		List<List<Integer>> res = new LinkedList<>();
		if (root == null) {
			return res;
		}
		Q.add(root);
		int tag = 1;
		while(!Q.isEmpty()) {
			List<Integer> temp = new LinkedList<>();
			int size = Q.size();
			for (int i = 0; i < size; i++) {
				TreeNode node = Q.poll();
				if (node.right != null) {
					Q.add(node.right);
				}
				if (node.left != null) {
					Q.add(node.left);
				}
				if (tag == 1) {
					temp.add(0, node.val);
				} else if (tag == 0) {
					temp.add(node.val);
				}
			}
			res.add(temp);
			if (tag == 1) {
				tag = 0;
			} else if (tag == 0) {
				tag = 1;
			}
		}
		return res;
	}
}
