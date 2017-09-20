package review;
//用DP的方法时间复杂度为O(n^2)虽然会TLE，但是必须掌握这样的分析思路
public class JumpGameII {
	public int jump(int[] nums) {
		int[] dp = new int[nums.length];
		dp[0] = 0;
		for (int i = 1; i < nums.length; i++) {
			dp[i] = Integer.MAX_VALUE;
		}
		for (int i = 1; i < nums.length; i ++) {
			for (int j = 0; j < i; j++) {
				if (dp[j] != Integer.MAX_VALUE && j + nums[j] >= i) {
					dp[i] = Math.min(dp[i], dp[j]+1);
				}
			}
		}
		return dp[nums.length - 1];
	}
}

/*
//version 2: Greedy
public class Solution {
 public int jump(int[] A) {
     int n = nums.length;
        int res = 0;
        //start对应我们还没能作为起始点的第一个点
        int start = 0;
        //end作为我每次能走到最远的点
        int end = 0;
        //循环的每次我都会考虑从还没作为起始点的点到上一次能走到最远的点
        //把这些点作为起始点去考虑能走到最远是多少
        while (end < n-1) {
            res ++;
            int curMax = end;
            for (int i = start; i <= end; i++) {
                curMax = Math.max(curMax, i + nums[i]);
            }
            start = end + 1;
            end = curMax;
        }
        return res;
 }
}
*/