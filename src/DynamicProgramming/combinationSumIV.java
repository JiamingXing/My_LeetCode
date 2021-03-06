package DynamicProgramming;
//第一种用recursion的方法做，但是会超时有很多很多多余运算
//要求计算有多少种方案求和等于target 所以很容易也能想到用DP

/*
public class combinationSumIV {
	int sum = 0;
	public int combinationSum4(int[] nums, int target){
		 for(int n : nums){
	            helper(nums, target-n);
	        }
	        return sum;
	}
	public void helper(int[] nums, int target){
		if(target == 0){
            sum ++;
            return;
        }else if(target < 0){
            return;
        }
        for(int n : nums){
            helper(nums, target-n);
            
        }
	}
}
*/
//自己写出来的~ 但是需要总结一下怎么想出来的
public class combinationSumIV {
	public int combinationSum4(int[] nums, int target){
		int[] dp = new int[target + 1];
        dp[0] = 1;
        //dp[i] = (在第一个元素固定为n的情况下) dp[i-n]
        for(int i = 1; i <= target; i ++){
            for(int n : nums){
                if(n > i){
                    continue;
                }
                dp[i] += dp[i-n];
            }
        }
        return dp[target];
	}
}

//背包型动态规划 循环的顺序不是固定的有的时候target放在外层，有的时候遍历数组放在外层
/*
public class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        // for (int i = 1; i <= target; i++) {
        // 	for (int j = 0; j < nums.length; j++) {
        // 		if (nums[j] > i) {
        // 			continue;
        // 		}
        // 		dp[i] += dp[i-nums[j]];
        // 	}
        // }
        for (int i = 0; i < nums.length; i++) {
            for (int j = nums[i]; j <= target; j++) {
                dp[j] += dp[j-nums[i]];
            }
        }
        return dp[target];
    }
}
*/
