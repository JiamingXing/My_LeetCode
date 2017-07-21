package review;
//这道题很巧妙的是我重新构造原数组两头加1来处理边界条件。
public class BurstBallons {
	public int maxCoins(int[] nums) {
		int n = nums.length;
		int[][] dp = new int[n+2][n+2];
		int[][] visit = new int[n+2][n+2];
		int[] arr = new int[n+2];
		for (int i = 1; i <= n; i++) {
			arr[i] = nums[i-1];
		}
		arr[0] = 1;
		arr[n+1] = 1;
		return helper(arr, dp, visit, 1, n);
	}
	private int helper(int[] arr, int[][] dp, int[][] visit, int start, int end) {
		if (visit[start][end] == 1) {
			return dp[start][end];
		}
		int res = 0;
		for (int k = start; k <= end; ++k) {
			int mid = arr[start - 1] * arr[k] * arr[end+1];
			int left = helper(arr, dp, visit, start, k-1);
			int right = helper(arr, dp, visit, k+1, end);
			res = Math.max(res, left+right+mid);
		}
		visit[start][end] = 1;
		dp[start][end] = res;
		return res;
	}
}

//for循环的写法思路是一样的
/*
public class Solution {
public int maxCoins(int[] nums) {
    if (nums == null || nums.length == 0) return 0;
    
    int[][] dp = new int[nums.length][nums.length];
    for (int len = 1; len <= nums.length; len++) {
        for (int start = 0; start <= nums.length - len; start++) {
            int end = start + len - 1;
            for (int i = start; i <= end; i++) {
                int coins = nums[i] * getValue(nums, start - 1) * getValue(nums, end + 1);
                coins += i != start ? dp[start][i - 1] : 0; // If not first one, we can add subrange on its left.
                coins += i != end ? dp[i + 1][end] : 0; // If not last one, we can add subrange on its right
                dp[start][end] = Math.max(dp[start][end], coins);
            }
        }
    }
    return dp[0][nums.length - 1];
}

private int getValue(int[] nums, int i) { // Deal with num[-1] and num[num.length]
    if (i < 0 || i >= nums.length) {
        return 1;
    }
    return nums[i];
}
*/
