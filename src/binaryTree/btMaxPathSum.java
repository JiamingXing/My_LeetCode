package binaryTree;
// any to any maximum path sum
public class btMaxPathSum {
	private class ResultType {
        int onePass;
        int twoPass;
        public ResultType (int onePass, int twoPass) {
            this.onePass = onePass;
            this.twoPass = twoPass;
        }
    }
	public int maxPathSum(TreeNode root) {
        return helper(root).twoPass;
    }
	private ResultType helper(TreeNode root) {
        if (root == null) {
            return new ResultType(0, Integer.MIN_VALUE);
        }
        ResultType left = helper(root.left);
        ResultType right = helper(root.right);
        int max = Math.max(left.onePass, right.onePass);
        int curOnePass = Math.max(max, 0) + root.val;
        int curTwoPass = Math.max(left.onePass, 0) + Math.max(right.onePass, 0) + root.val;
        curTwoPass = Math.max(Math.max(left.twoPass, right.twoPass), curTwoPass);
        return new ResultType(curOnePass, curTwoPass);
    }
}
