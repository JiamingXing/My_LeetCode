package binaryTree;
//速度有点慢 但是自己写出来了。。 有没有更好地方法？
//因为我copy array 所以会多出很多空间时间复杂度 最好是完全用index进行操作
public class ConstructBTPreIn {
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		if (preorder.length == 0) {
			return null;
		}
		TreeNode root = new TreeNode(preorder[0]);
		int pos = getIndex (inorder, preorder[0]);
		if (pos == 0) {
			root.left = null;
		} else {
			root.left = buildTree (copyArray(preorder, 1, pos), copyArray(inorder, 0, pos - 1));;
		}
		if (pos + 1 == inorder.length) {
			root.right = null;
		} else {
			root.right = buildTree(copyArray(preorder, pos+1, preorder.length - 1), copyArray(inorder, pos+ 1, inorder.length - 1));
		}
		return root;
	}
	private int getIndex(int[] nums, int target) {
		int i = 0;
		while (nums[i] != target) {
			i++;
		}
		return i;
	}
	private int[] copyArray(int[] nums, int start, int end) {
		int[] result = new int[end - start + 1];
		int i = start;
		int j = 0;
		while (i <= end) {
			result[j] = nums[i];
			i++;
			j++;
		}
		return result;
	}

}

//看看别人的代码简洁
/*
public TreeNode buildTree(int[] preorder, int[] inorder) {
    return helper(0, 0, inorder.length - 1, preorder, inorder);
}

public TreeNode helper(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
    if (preStart > preorder.length - 1 || inStart > inEnd) {
        return null;
    }
    TreeNode root = new TreeNode(preorder[preStart]);
    int inIndex = 0; // Index of current root in inorder
    for (int i = inStart; i <= inEnd; i++) {
        if (inorder[i] == root.val) {
            inIndex = i;
        }
    }
    root.left = helper(preStart + 1, inStart, inIndex - 1, preorder, inorder);
    root.right = helper(preStart + inIndex - inStart + 1, inIndex + 1, inEnd, preorder, inorder);
    return root;
}
*/
