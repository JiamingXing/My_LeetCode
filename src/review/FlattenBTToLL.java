package review;
//很难想的一个思路 体会一下把
//这道题的思路很像linkedlist的思路 就是操作指针
//但是树结构中有不少这样的操作指针的题，就连inorder traversal这类的题的非递归
//写法都有这样的影子 想起来很困难，做了好几遍可能还没有熟悉做法
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


/*
public void flatten(TreeNode root) {
    if (root == null) return;
    
    TreeNode left = root.left;
    TreeNode right = root.right;
    
    root.left = null;
    
    flatten(left);
    flatten(right);
    
    root.right = left;
    TreeNode cur = root;
    while (cur.right != null) cur = cur.right;
    cur.right = right;
}
*/
