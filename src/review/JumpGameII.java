package review;
//用DP的方法时间复杂度为O(n^2)虽然在leetcode上会超时，但是必须掌握这样的分析思路
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
     if (A == null || A.length == 0) {
         return -1;
     }
     int start = 0, end = 0, jumps = 0;
     while (end < A.length - 1) {
         jumps++;
         int farthest = end;
         for (int i = start; i <= end; i++) {
             if (A[i] + i > farthest) {
                 farthest = A[i] + i;
             }
         }
         start = end + 1;
         end = farthest;
     }
     return jumps;
 }
}
*/