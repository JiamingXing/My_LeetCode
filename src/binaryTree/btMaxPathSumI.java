package binaryTree;
//same as btMaxPathSum, better solution

public class btMaxPathSumI {
	private class ResultType{
		int singlePath;
		int maxPath;
		ResultType(int singlePath, int maxPath){
			this.singlePath = singlePath;
			this.maxPath = maxPath;
		}
		private ResultType helper(TreeNode root){
			if(root == null){
				return new ResultType(0, Integer.MIN_VALUE);
			}
			
			// divide 
			ResultType left = helper(root.left);
			ResultType right = helper(root.right);
			
			//conquer
			int singlePath = Math.max(left.singlePath, right.singlePath) + root.val;
			singlePath = Math.max(singlePath, 0);
			
			int maxPath = Math.max(left.maxPath, right.maxPath);
			maxPath = Math.max(maxPath, left.singlePath + right.singlePath + root.val);
			
			return new ResultType(singlePath, maxPath);
		}
		
		public int maxPathSum(TreeNode root){
			ResultType result = helper(root);
			return result.maxPath;
		}
	}

}
