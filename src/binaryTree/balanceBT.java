package binaryTree;

public class balanceBT {
	public boolean isBalanced(TreeNode root) {
		if(root == null){
            return true;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        if(left == right || left + 1 == right || right + 1 == left){
            if(isBalanced(root.left) && isBalanced(root.right)){
                return true;
            }else{
                return false;
            }
        }
        return false;
	}
	public int maxDepth(TreeNode root) {
		if(root == null){
			return 0;
		}
		int left = maxDepth(root.left);
		int right = maxDepth(root.right);
		return Math.max(left, right) + 1;
	}

}

/*
public class balanceBT {
	public boolean isBalanced(TreeNode root) {
		return maxDepth(root) != -1;
	}
	private int maxDepth(TreeNode root){
		if(root == null){
			return 0;
		}
		
		int left = maxDepth(root.left);
		int right = maxDepth(root.right);
		if(left == -1 || right == -1 || Math.abs(left - right) > 1){
			return -1;
		}
		return Math.max(left,right) + 1;
	}
	
}
*/



/*
 仔细研究思考下第二种写法 



public class balanceBT{
	public class ResultType{
		public boolean isBalanced;
		public int maxDepth;
		public ResultType(boolean isBalanced, int maxDepth){
			this.isBalanced = isBalanced;
			this.maxDepth = maxDepth;
		}
	}

	public boolean isBalanced(TreeNode root){
		return helper(root).isBalanced;
	}
	
	private ResultType helper(TreeNode root){
		if(root == null){
			return new ResultType(true, 0);
		}
		ResultType left = helper(root.left);
		ResultType right = helper(root.right);
		// subtree is not balanced
		if(!left.isBalanced || !right.isBalanced){
			return new ResultType(false, -1);
		}
		// root is not balanced
		if(Math.abs(left.maxDepth - right.maxDepth) > 1){
		    return new ResultType(false, -1);
		}
		return new ResultType(true, Math.max(left.maxDepth, right.maxDepth) + 1);
	}
}


*/