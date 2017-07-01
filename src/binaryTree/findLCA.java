package binaryTree;
//学习这道题的思路是怎么形成的？？？？？
//碰到二叉树的问题，就想一想整颗树在这个问题上的结果和左右儿子在这个问题上的结果有什么联系？
//在root为根的二叉树中找p q的LCA
//如果没有LCA那么返回什么？分三种情况：
//如果碰到A，就返回A
//如果碰到B，就返回B
//如果都没有就返回null
//p q 以后的节点都不再运行
public class findLCA {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
		//退出递归的条件
		if(root == null || root == p || root == q){
			return root;
		}
		// divide
		TreeNode left = lowestCommonAncestor(root.left, p, q);
		TreeNode right = lowestCommonAncestor(root.right, p, q);
		
		// conquer
		if(left != null && right != null){
			return root;
		}else if(left != null){
			return left;
		}else{
			return right;
		}
	}

}
