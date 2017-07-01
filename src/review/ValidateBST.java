package review;

public class ValidateBST {
	private class ResultType {
		boolean isVal;
		int min;
		int max;
		public ResultType(boolean isVal, int min, int max) {
			this.isVal = isVal;
			this.min = min;
			this.max = max;
		}
	}
	public boolean isValidBST(TreeNode root) {
		return helper(root).isVal;
	}
	private ResultType helper(TreeNode root) {
		if (root == null) {
			return new ResultType(true, Integer.MAX_VALUE, Integer.MIN_VALUE); 
		}
		
		ResultType left = helper(root.left);
		ResultType right = helper(root.right);
		if (!left.isVal || !right.isVal ){
			return new ResultType(false, 0, 0);
		}
		//这里加一个空的判断很重要
		if (root.left != null && left.max >= root.val || root.right != null && right.min <= root.val) {
			return new ResultType(false, 0, 0);
		}
		return new ResultType(true, Math.min(root.val, left.min), Math.max(root.val, right.max));
	}
}
//如果节点上的值是边界，这么处理？
/*
private boolean help(TreeNode p, Integer low, Integer high) {
    if (p == null) return true;
    return (low == null || p.val > low) && (high == null || p.val < high) && help(p.left, low, p.val) && help(p.right, p.val, high);
}

public boolean isValidBST(TreeNode root) {
    return help(root, null, null);
}
*/
//别人写的三行代码
//从上往下的递归
/*
public class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    public boolean isValidBST(TreeNode root, long minVal, long maxVal) {
        if (root == null) return true;
        if (root.val >= maxVal || root.val <= minVal) return false;
        return isValidBST(root.left, minVal, root.val) && isValidBST(root.right, root.val, maxVal);
    }
}
*/

//一开始自己的写的版本，大方向没有错，但是没有处理好边界条件 导致几个特殊的case没法通过
//[Integer.MAX_VALUE]
//当出现null的时候怎么处理好的问题
/*
public class Solution {
    private class ResultType {
		boolean isVal;
		int min;
		int max;
		public ResultType(boolean isVal, int min, int max) {
			this.isVal = isVal;
			this.min = min;
			this.max = max;
		}
	}
    public boolean isValidBST(TreeNode root) {
        return helper(root).isVal;
    }
    private ResultType helper(TreeNode root) {
		if (root == null) {
			return new ResultType(true, Integer.MAX_VALUE, Integer.MIN_VALUE); 
		}
		ResultType left = helper(root.left);
		ResultType right = helper(root.right);
		if (left.isVal && right.isVal) {
			if (left.max < root.val && right.min > root.val) {
				return new ResultType(true, left.min, right.max);
			}
		}
		return new ResultType(false, 0, 0);
	}
}
*/
