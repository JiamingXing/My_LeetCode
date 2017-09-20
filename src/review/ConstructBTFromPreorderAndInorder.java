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
		//当前子树的根为prestart
		TreeNode root = new TreeNode(preorder[preStart]);
		int index = 0;
		//找到根在inorder的位置
		while (index < inorder.length) {
			if (inorder[index] == preorder[preStart]) {
				break;
			}
			index++;
		}
		//左子树的根节点应该是prestart + 1 对于inorder的区间是instart 到 index-1
		root.left = helper(preorder, inorder, inStart, index-1, preStart+1);
		//右节点的preStart 怎么找到的？？ preStart+index-inStart+1
		//index - inStart = leftSubtree.length; preStart+leftSubtree.length+1 = right.root position
		//右子树对于inorder的区间从index+1到inEnd 右子树的根节点等于当前根+左子树的长度+1
		//左子树的长度对应的inorder里 instart到index  -- index-instart 
		root.right = helper(preorder, inorder, index+1, inEnd, preStart+index-inStart+1);
		return root;
	}
}
