package review;

public class ConstructBTFromPreorderAndInorder {
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		if (preorder.length == 0) {
			return null;
		}
		return helper(preorder, inorder, 0, inorder.length-1, 0);
	}
	private TreeNode helper(int[] preorder, int[] inorder, int inStart, int inEnd, int preStart) {
		if (preStart > preorder.length-1 || inStart > inEnd) {
			return null;
		}
		TreeNode root = new TreeNode(preorder[preStart]);
		int index = 0;
		while (index < inorder.length) {
			if (inorder[index] == preorder[preStart]) {
				break;
			}
			index++;
		}
		root.left = helper(preorder, inorder, inStart, index-1, preStart+1);
		//右节点的preStart 怎么找到的？？ preStart+index-inStart+1
		//index - inStart = leftSubtree.length; preStart+leftSubtree.length+1 = right.root position
		root.right = helper(preorder, inorder, index+1, inEnd, preStart+index-inStart+1);
		return root;
	}
}
