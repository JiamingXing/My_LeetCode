package binaryTree;
//Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
public class convertSortedArratToBST {
	public TreeNode sortedArrayToBST(int[] nums) {
		if(nums.length == 0){
	           return null;
	       }
	       TreeNode root = helper(nums, 0, nums.length - 1);
	       return root;
	}
	 public TreeNode helper(int nums[], int start, int end){
		 if(start > end){
	            return null;
	        }
	        int mid = (start + end) / 2;
	        TreeNode root = new TreeNode(nums[mid]);
	        root.left = helper(nums, start, mid - 1);
	        root.right = helper(nums, mid + 1, end);
	        return root;
	 }

}
//有点像binary search 关键也在于搞清楚边界条件。
//一开始写程序 每次取mid的思路显而易见，但是就像写binary search的时候一样
//怎样可以保证不出现死循环或者溢出的情况 比如start > end start >= end?
//按照binary search里的习惯应该写成 start + 1 < end 二分时
//不进行 mid + 1  mid-1的操作直接用mid