package review;
//很难想的一个思路 体会一下把
public class FlattenBTToLL {
	private TreeNode prev = null;
	public void flatten(TreeNode root) {
		if (root == null) {
			return;
		}
		flatten(root.right);
		flatten(root.left);
		root.right = prev;
		root.left = null;
		prev = root;
	}
}
