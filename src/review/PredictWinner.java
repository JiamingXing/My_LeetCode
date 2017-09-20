package review;
//看题目以为是明显的博弈型动态规划，但是硬生生地转换成了区间型动态规划问题
//这里有个比较明显的标志就是只能从数组的头或者尾取数字那我们本质就应该是从一个点往两头
//也就是说最小的状态应该是dp[i][i]
//最难想的是这个state的定义 dp[i][j]表示头是i尾是j先手玩家能比后手玩家多拿多少
//这个state的定义就是这道题抓换的关键 很难想到
//dp[i][j] = max(nums[i] - dp[i+1][j], nums[j] - dp[i][j-1])
//对于(i,j)的情况此时的先手玩家只有两种可能，取i或者取j那么要让它比后手玩家多取的尽量大
//也就是说我们希望让[i+1, j] 和[i, j-1]两种情况先手玩家比后手尽量少，因为此时的先手玩家
//就是对应我们(i,j)的后手玩家
public class PredictWinner {
	public boolean PredictTheWinner(int[] nums) {
		int n = nums.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = nums[i];
        }
        for (int len = 1; len < n; len ++) {
            for (int i = 0; i < n - len; i++) {
                int j = i + len;
                dp[i][j] = Math.max(nums[i] - dp[i+1][j], nums[j] - dp[i][j-1]);
            }
        }
        return dp[0][n-1] >= 0;
	}
}

//O(n) space complexity
/*
public boolean PredictTheWinner(int[] nums) {
    if (nums == null) { return true; }
    int n = nums.length;
    if ((n & 1) == 0) { return true; } // Improved with hot13399's comment.
    int[] dp = new int[n];
    for (int i = n - 1; i >= 0; i--) {
        for (int j = i; j < n; j++) {
            if (i == j) {
                dp[i] = nums[i];
            } else {
                dp[j] = Math.max(nums[i] - dp[j], nums[j] - dp[j - 1]);
            }
        }
    }
    return dp[n - 1] >= 0;
}
*/
