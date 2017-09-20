package review;

import java.util.ArrayList;
import java.util.List;

//DFS
public class BTRightSideView {
	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		helper(root, res, 1);
		return res;
	}
	private void helper(TreeNode root, List<Integer> res, int depth) {
		if (root == null) {
			return;
		}
		if (res.size() < depth) {
			res.add(root.val);
		}
		helper(root.right, res, depth+1);
		helper(root.left, res, depth+1);
	}
}

/*
//BFS level-order traversal
public class BTRightSideView {
	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> Q = new LinkedList<>();
        Q.add(root);
        while (!Q.isEmpty()) {
            int size = Q.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = Q.poll();
                if (i == 0) {
                    res.add(cur.val);
                }
                if (cur.right != null) {
                    Q.add(cur.right);
                }
                if (cur.left != null) {
                    Q.add(cur.left);
                }
            }
        }
        return res;
	}
}
*/
