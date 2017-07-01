package review;

public class ConvertSortedArrayBST {
	public TreeNode sortedArrayToBST(int[] nums) {
		if (nums.length == 0) {
			return null;
		}
		TreeNode root = helper(nums, 0, nums.length-1);
		return root;
	}
	private TreeNode helper(int[] nums, int start, int end) {
		if (start > end) {
			return null;
		}
		int mid = (start + end) / 2;
		TreeNode root = new TreeNode(nums[mid]);
		root.left = helper(nums, start, mid-1);
		root.right = helper(nums, mid+1, end);
		return root;
	}
}
//关键在于搞清楚边界条件 可以多试几个简单的test case 比如长度为4 为5看看算法可不可行