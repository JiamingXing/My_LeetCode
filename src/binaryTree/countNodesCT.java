package binaryTree;
//时间复杂度太高超时。。
public class countNodesCT {
	public int countNodes(TreeNode root) {
		int ctLevel = maxLevel(root);
		int nums = lastLevelNum(root, ctLevel);
		return (int)Math.pow(2, ctLevel - 1) + nums;
		
		
	}
	public int maxLevel(TreeNode root){
		if(root == null){
			return 0;
		}
		int left = maxLevel(root.left);
		return left + 1;
	}
	public int lastLevelNum(TreeNode root, int level){
		if(root == null){
			return 0;
		}
		if(root.left == null && root.right == null && level == 1){
			return 1;
		}
		int leftNum = lastLevelNum(root.left, level - 1);
		int rightNum = lastLevelNum(root.right, level - 1);
		return leftNum + rightNum;
	}

}
