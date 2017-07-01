package binaryTree;
//对preorder inorder postorder 还不够熟悉
//这是别人的思路bottom-to-up recursion 先向右 
//体会一下这个思路怎么想到的 感觉有点难想到 先右后左
public class flattenBTToLL {
	private TreeNode prev;
	public void flatten(TreeNode root) {
		if(root == null){
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
	flatten(root,null);
}
private TreeNode flatten(TreeNode root, TreeNode pre) {
	if(root==null) return pre;
	pre=flatten(root.right,pre);    
	pre=flatten(root.left,pre);
	root.right=pre;
	root.left=null;
	pre=root;
	return pre;
}
*/
/*
 * 
 non recursive solution
public class Solution{
	public void flatten(TreeNode root){
		if(root == null){
			return;
		}
		if(root.left == null && root.right == null){
			return;
		}
		while(root != null){
			if(root.left == null){
				root = root.right;
				continue;
			}
			TreeNode left = root.left;
			while(left.right != null){
				left = left.right;
			}
			left.right = root.right;
			root.right = root.left;
			root.left = null;
			root = root.right;
		}
	}
}
*/