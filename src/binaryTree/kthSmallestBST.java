package binaryTree;

import java.util.ArrayList;
import java.util.List;

// kth element in inorder traversal?
// inorder is left, root, right 从小到大
public class kthSmallestBST {
	public int kthSmallest(TreeNode root, int k) {
		inOrderBT temp = new inOrderBT();
		List<Integer> result = new ArrayList<>(temp.inorderTraversal(root));
		return result.get(k - 1);
	}

}
//下面的方法也是始终体现递归的思路
/*

public class kthSmallestBST{
	public int kthSmallest(TreeNode root, int k){
		int count = countNodes(root.left);
		if(k <= count){
			return kthSmallest(root.left, k);
		}else if(k > count + 1){
			return kthSmallest(root.right, k - 1 - count);
		}else{
			return root.val;
		}
	}
	public int countNodes(TreeNode n){
		if(n == null){
			return 0;
		}
		return countNodes(n.left) + countNodes(n.right) + 1;
	}
}
*/
