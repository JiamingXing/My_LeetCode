package binaryTree;

public class BinaryTreeSucessor {
	public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
		if (root == null) {
            return null;
        }
        if (p.val >= root.val) {
            return inorderSuccessor(root.right, p);
        } else {
            TreeNode left = inorderSuccessor(root.left, p);
            return left != null ? left : root;
        }
	}
}


// Predecessor
/*
public TreeNode predecessor(TreeNode root, TreeNode p) {
	  if (root == null)
	    return null;

	  if (root.val >= p.val) {
	    return predecessor(root.left, p);
	  } else {
	    TreeNode right = predecessor(root.right, p);
	    return (right != null) ? right : root;
	  }
	}
*/