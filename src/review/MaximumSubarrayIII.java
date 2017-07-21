package review;
//给一个整数数组和一个整数k，找出k个不重叠子数组使他们和最大
//之前做过找连续子数组和两个不重叠子数组的和
public class MaximumSubarrayIII {
	public int maxSubArray(int[] nums, int k) {
		int n = nums.length;
		if (n < k) {
			return 0;
		}
		int[][] global = new int[k+1][n+1];
		int[][] local = new int[k+1][n+1];
		
		for (int i = 1; i <= k; i++) {
			local[i][i-1] = Integer.MIN_VALUE;
			for (int j = i; j <= n; j++) {
				local[i][j] = Math.max(local[i][j-1], global[i-1][j-1]) + nums[j-1];
				if (j == i) {
					global[i][j] = local[i][j];
				} else {
					global[i][j] = Math.max(global[i][j-1], local[i][j]);
				}
			}
		}
		return global[k][n];
	}
}

//比较直接的写法思路 没有时间优化之前的写法。
/*
public class MaximumSubarrayIII {
	public int maxSubArray(int[] nums, int k) {
		int n = nums.length;
		if (n < k) {
			return 0;
		}
		int[][] dp = new int[n+1][k+1];
		dp[0][0] = 0;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= k; j++) {
				dp[i][j] = Integer.MIN_VALUE;
			}
		}
		for (int i = 1; i <= n; i++) {
			dp[i][0] = 0;
			for (int j = 1; j <= k; j++) {
				dp[0][j] = 0;
				for (int x = j-1; x < i; x++) {
					dp[i][j] = Math.max(dp[i][j], dp[x][j-1] + subarray(nums, x+1, i));
				}
			}
		}
		return dp[n][k];
	}
	private int subarray(int[] nums, int start, int end) {
		if (start == end) {
			return nums[start - 1];
		}
		int max = Integer.MIN_VALUE;
		int sum = 0;
		int minSum = 0;
		for (int i = start; i <= end; i++) {
			sum += nums[i-1];
			max = Math.max(max, sum - minSum);
			minSum = Math.min(sum, minSum);
		}
		return max;
	}
}
*/
