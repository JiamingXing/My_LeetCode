package review;
//这样写会有很多重复的结果进去所以不可取
//public class PathSumIII {
//	public int pathSum(TreeNode root, int sum) {
//		return helper(root, sum);
//	}
//	private int helper(TreeNode root, int sum) {
//		if (root == null) {
//			return 0;
//		}
//		int left_root = helper(root.left, sum - root.val);
//		int right_root = helper(root.right, sum - root.val);
//		int left = helper(root.left, sum);
//		int right = helper(root.right, sum);
//		return left_root + right_root + left + right + (sum == root.val ? 1 : 0);
//	}
//}

//divide and conquer
public class PathSumIII {
	public int pathSum(TreeNode root, int sum) {
		if (root == null) {
			return 0;
		}
		int left = pathSum(root.left, sum);
		int right = pathSum(root.right, sum);
		return left+right+helper(root, sum);
	}
	private int helper(TreeNode root, int sum) {
		if (root == null) {
			return 0;
		}
		int left = helper(root.left, sum-root.val);
		int right = helper(root.right, sum-root.val);
		return left + right + root.val == sum ? 1 : 0;
	}
}

//用hashmap会快很多
//helper中cursum存的个数减一 很容易被忽略
/*
public int pathSum(TreeNode root, int sum) {
    HashMap<Integer, Integer> preSum = new HashMap();
    preSum.put(0,1);
    return helper(root, 0, sum, preSum);
}

public int helper(TreeNode root, int currSum, int target, HashMap<Integer, Integer> preSum) {
    if (root == null) {
        return 0;
    }
    
    currSum += root.val;
    int res = preSum.getOrDefault(currSum - target, 0);
    preSum.put(currSum, preSum.getOrDefault(currSum, 0) + 1);
    
    res += helper(root.left, currSum, target, preSum) + helper(root.right, currSum, target, preSum);
    preSum.put(currSum, preSum.get(currSum) - 1);
    return res;
}
*/
