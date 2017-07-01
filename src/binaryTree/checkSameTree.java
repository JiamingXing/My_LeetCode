package binaryTree;

public class checkSameTree {
	public boolean isSameTree(TreeNode p, TreeNode q) {
		 if(p == null && q == null){
	            return true;
	        }
	        if(p == null || q == null){
	            return false;
	        }
	        // divide
	        boolean left = isSameTree(p.left, q.left);
	        boolean right = isSameTree(p.right, q.right);
	        
	        //conquer
	        if(left && right){
	            if(p.val == q.val){
	                return true;
	            }else{
	                return false;
	            }
	        }else{
	            return false;
	        }
	}

}
