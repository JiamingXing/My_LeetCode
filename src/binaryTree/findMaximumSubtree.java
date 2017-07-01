package binaryTree;
//Amazon 1st easy
public class findMaximumSubtree {
	public TreeNode maxSubtree(TreeNode root){
		return helper(root).root;
	}
	//currentSum is the sum of the whole subtree
	//maxSum is the max sum of subtree and the root
	public class ResultType{
		TreeNode root;
		int currentSum;
		int maxSum;
		ResultType(TreeNode root, int currentSum, int maxSum){
			this.root = root;
			this.currentSum = currentSum;
			this.maxSum = maxSum;
		}
	}
	public ResultType helper(TreeNode root){
		//这一步可能有问题
		//比如某个node左子树空 右子树不空但是sum为负
		//那这种情况 返回的会是  null和sum = 0 这样对上层的计算会出现影响
		if(root == null){
			return new ResultType(null, 0, Integer.MIN_VALUE);
		}
		if(root.left == null && root.right == null){
			return new ResultType(root, root.val, root.val);
		}
		ResultType left = helper(root.left);
		ResultType right = helper(root.right);
		if(left.currentSum + right.currentSum + root.val > left.maxSum && left.currentSum + right.maxSum + root.val > right.maxSum){
			return new ResultType(root, root.val + left.currentSum + right.currentSum, root.val + left.currentSum + right.currentSum);
		}else{
			return new ResultType(right.maxSum > left.maxSum ? right.root : left.root, root.val + left.currentSum + right.currentSum, Math.max(left.maxSum, right.maxSum));
		}
		
	}

}
