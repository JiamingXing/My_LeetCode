package review;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {
	public List<String> binaryTreePaths(TreeNode root) {
		List<String> res = new ArrayList<>();
		if (root == null) {
			return res;
		}
		helper(root, "", res);
		return res;
	}
	private void helper(TreeNode root, String s, List<String> res) {
		s = s + root.val;
		if (root.left == null && root.right == null) {
			res.add(s);
			return;
		}
		if (root.left != null) {
			helper(root.left, s + "->", res);
		}
		if (root.right != null) {
			helper(root.right, s + "->", res);
		}
	}
}
