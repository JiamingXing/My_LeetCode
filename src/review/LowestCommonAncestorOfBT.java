package review;

public class LowestCommonAncestorOfBT {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null || root == p || root == q) {
			return root;
		}
		// divide
		TreeNode left = lowestCommonAncestor(root.left, p, q);
		TreeNode right = lowestCommonAncestor(root.right, p, q);
		//conquer
		//p和q分别在这个root的左子树和右子树
		if (left != null && right != null) {
			return root;
			//左边碰到了p或q
		} else if (left != null) {
			return left;
			//右边碰到了p或q
		} else if (right != null){
			return right;
		} else {
			return null;
		}
	}
}
