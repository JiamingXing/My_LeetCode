package binaryTree;
// any to any maximum path sum
public class btMaxPathSum {
	public int maxPathSum(TreeNode root) {
		
		// divide
		int left = maxPathSum(root.left);
		int right = maxPathSum(root.right);
		int leftMax = rootMax(root.left);
		int rightMax = rootMax(root.right);
		
		//conquer
		int throughMax = Math.max(leftMax, 0) + Math.max(rightMax, 0) + root.val;
		return threeMax(left, right, throughMax);
	}
	public int rootMax(TreeNode root){
		if(root == null){
			return Integer.MIN_VALUE;
		}
		//divide
		int left = rootMax(root.left);
		int right = rootMax(root.right);
		
		return Math.max(Math.max(left,right), 0) + root.val;
	}
	public int threeMax(int a, int b, int c){
		if(a >= b){
			if(a >= c){
				return a;
			}else{
				return c;
			}
		}else{
			if(b >= c){
				return b;
			}else{
				return c;
			}
		}
	}

}
