package review;
//把二分搜索的思路用在tree中？
//这道题分为两步走
//第一步先找到最后一层以上所有的node个数
//第二步统计最后一层的node个数
public class CountCompleteTreeNode {
	public int countNodes(TreeNode root) {
        if (root == null) {
        	return 0;
        }
        if (root.left == null) {
        	return 1;
        }
        int height = 0;
        int sum = 0;
        TreeNode cur = root;
        //sum表示最后一层以上所有的点个数
        while (cur.left != null) {
        	sum += (1 << height);
        	height ++;
        	cur = cur.left;
        }
        return sum + countLastLevel(root, height);
    }
	private int countLastLevel(TreeNode root, int height) {
		if (height == 1) {
			if (root.right != null) {
				return 2;
			} else if (root.left != null) {
				return 1;
			} else {
				return 0;
			}
		}
		TreeNode midNode = root.left;
		int curHeight = 1;
		while (curHeight < height) {
			curHeight ++;
			midNode = midNode.right;
		}
		if (midNode == null) {
			return countLastLevel(root.left, height - 1);
		} else {
			return (1 << (height - 1)) + countLastLevel(root.right, height-1);
		}
	}
}
