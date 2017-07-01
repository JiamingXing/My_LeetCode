package review;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversalII {
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> res= new ArrayList<>();
		if(root == null) {
			return res;
		}
		Queue<TreeNode> Q = new LinkedList<>();
		Q.add(root);
		while(!Q.isEmpty()) {
			int size = Q.size();
			List<Integer> temp = new ArrayList<>();
			for (int i = 0; i < size; i++) {
				TreeNode node = Q.poll();
				temp.add(node.val);
				if(node.left != null) {
					Q.add(node.left);
				}
				if (node.right != null) {
					Q.add(node.right);
				}
			}
			res.add(0, temp);
		}
		return res;
	}
}
