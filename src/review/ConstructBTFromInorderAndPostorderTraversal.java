package review;

public class ConstructBTFromInorderAndPostorderTraversal {
	public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || inorder.length == 0) {
            return null;
        }
        return helper(inorder, postorder, postorder.length-1, 0, inorder.length-1);
    }
	private TreeNode helper(int[] inorder, int[] postorder, int rootPos, int instart, int inend) {
        if (rootPos < 0 || instart > inend) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[rootPos]);
        int index = instart;
        while (index <= inend) {
            if (inorder[index] == root.val) {
                break;
            }
            index ++;
        }
        root.left = helper(inorder, postorder, rootPos-inend+index-1, instart, index-1);
        root.right = helper(inorder, postorder, rootPos-1, index+1, inend);
        return root;
    }
}
