package binaryTree;

public class btNumOfPathSum {
	public int pathSum(TreeNode root, int sum) {
		if(root == null){
            return 0;
        }
        //整棵树path的数量等于 root.left path数量 加上 root.right path数量 加上严格从root开始往下path的数量
        // divide
        int left = pathSum(root.left, sum);
        int right = pathSum(root. right, sum);
        
        //conquer
        return left + right + rootStartSum(root, sum);
	}
	public int rootStartSum(TreeNode root, int sum){
		if(root == null){
            return 0 ;
        }
        //严格从root开始往下左子树开始path数量加上右子树开始path的数量
        // divide
        int leftCount = rootStartSum(root.left, sum - root.val);
        int rightCount = rootStartSum(root.right, sum - root.val);
        
        // conquer
        //return leftCount + rightCount + (sum == 0 ? 1 : 0);
        return leftCount + rightCount + (sum == root.val ? 1 : 0);
        //return leftCount * (sum == 0 ? 1 : 0) + rightCount * (sum == 0 ? 1 : 0);
	}

}
//这道题犯了什么错误？
//一开始的时候在rootStartSum函数中没有考虑到什么时候返回
//写了return lefCount + rightCount
//发现不对之后 加了一个sum == 0?
//还是出问题 在用实例检验之后发现是在 sum == root.val的时候才加一
//但是整体的时间复杂度好像还是太高了 需要更高的方法？





//use hashmap key is prefix sum and value is how many ways to get this prefix sum; 
//想一想hashmap在这里起到了一个什么样的作用，再想一想一般什么时候用hashmap
//想一想在helper循环的最后为什么要减一
/*
public int pathSum(TreeNode root){
	HashMap<Integer, Integer> presum = new HashMap();
	presum.put(0, 1);
	return count;
}
int count = 0;
public void helper(TreeNode root, int currentSum, int target, HashMap<Integer, Integer> presum){
	if(root == null){
		return;
	}
	currentSum += root.val;
	if(presum.containsKey(currentSum - target)){
		count += presum.get(currentSum - target);
	}
	if(!presum.containsKey(currentSum)){
		presum.put(currentSum, 1);
	}else{
		presum.put(currentSum, presum.get(currentSum) + 1);
	}
	
	helper(root.left, currentSum, target, presum);
	helper(root.right, currentSum, target, presum);
	presum.put(currentSum, presum.get(currentSum) -1);
}
*/


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
