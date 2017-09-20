package review;
//关键在于怎么解决节点小于0的时候 节点为空的时候的情况
//思路比较直接我对于每一个节点我都考虑通过这个节点的最大和不通过这个节点的最大
//所以需要一个resultType
public class MaxPathSum {
	private class ResultType {
		//singlePath可以不包含当前点，意思是如果当前singlePath的结果小于0那么就设置成0
		//对于上层结果就是我不取这个节点
		int singlePath;
		//maxPath就相当于一个全局变量
		int maxPath;
		ResultType (int singlePath, int maxPath) {
			this.singlePath = singlePath;
			this.maxPath = maxPath;
		}
	}
	public int maxPathSum(TreeNode root) {
		ResultType res = helper(root);
		return res.maxPath;
	}
	private ResultType helper(TreeNode root) {
		if (root == null) {
			return new ResultType(0, Integer.MIN_VALUE);
		}
		ResultType left = helper(root.left);
		ResultType right = helper(root.right);
		int singlePath = Math.max(left.singlePath, right.singlePath) + root.val;
		singlePath = Math.max(singlePath, 0);
		int maxPath = Math.max(left.maxPath, right.maxPath);
		maxPath = Math.max(maxPath, left.singlePath + right.singlePath + root.val);
		return new ResultType(singlePath, maxPath);
	}
}


//Version 2:
//SinglePath也定义为，至少包含一个点。
/*
public class Solution {
 private class ResultType {
     int singlePath, maxPath;
     ResultType(int singlePath, int maxPath) {
         this.singlePath = singlePath;
         this.maxPath = maxPath;
     }
 }

 private ResultType helper(TreeNode root) {
     if (root == null) {
         return new ResultType(Integer.MIN_VALUE, Integer.MIN_VALUE);
     }
     // Divide
     ResultType left = helper(root.left);
     ResultType right = helper(root.right);

     // Conquer
     int singlePath =
         Math.max(0, Math.max(left.singlePath, right.singlePath)) + root.val;

     int maxPath = Math.max(left.maxPath, right.maxPath);
     maxPath = Math.max(maxPath,
                        Math.max(left.singlePath, 0) + 
                        Math.max(right.singlePath, 0) + root.val);

     return new ResultType(singlePath, maxPath);
 }

 public int maxPathSum(TreeNode root) {
     ResultType result = helper(root);
     return result.maxPath;
 }

}
*/

