package binaryTree;
//BST的中序遍历是升序数组！
//或者也递归着做？

public class checkValidateBST {
	private class ResultType{
        int min;
        int max;
        boolean judge;
        ResultType(int min, int max, boolean judge){
            this.min = min;
            this.max = max;
            this.judge = judge;
        }
    }
	public ResultType helper(TreeNode root){
        //怎么处理root为空的情况
        //我为了不让空节点影响后面的结果，最小值我设为Integer.MAX_VALUE 最大值设为Integer.MIN_VALUE
        if(root == null){
            return new ResultType(Integer.MAX_VALUE, Integer.MIN_VALUE, true);
        }
        // divide
        ResultType left = helper(root.left);
        ResultType right = helper(root.right);
        
        //conquer
        if(!left.judge || !right.judge){
            return new ResultType(0, 0, false);
        }
        if(root.left != null && left.max >= root.val || root.right != null && right.min <= root.val){
            return new ResultType(0, 0, false);
        }
        //如何排除bottom null节点返回的 MIN MAX？
        return new ResultType(Math.min(left.min, root.val), Math.max(right.max, root.val), true);
        // if(left.judge == true && right.judge == true){
        //     if(left.max < root.val && right.min > root.val){
        //         return new ResultType(Math.max(left.min, Integer.MIN_VALUE), Math.min(right.max, Integer.MAX_VALUE), true);
        //     }else{
        //         return new ResultType(0, 0, false);
        //     }
        // }else{
        //     return new ResultType(0, 0, false);
        // }
        
    }
	public boolean isValidBST(TreeNode root) {
		ResultType result = helper(root);
        return result.judge;
	}

}

//version2 : 对这棵树做中序遍历 自己写
/*
public class Solution{
	private int lastVal = Integer.MIN_VALUE;
	private boolean firstNode = true;
	public boolean isValidBST(TreeNode root){
		if(root == null){
			return true;
		}
		if(!isValidBST(root.left)){
			return false;
		}
		if(!isValidBST(root.right)){
			return false;
		}
		firstNode = false;
		lastVal = root.val;
		if(isValidBST(root.right)){
			return false;
		}
		return true;
	}
}
*/
