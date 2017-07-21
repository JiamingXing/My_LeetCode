package review;
//如果用正常的DP思路写的话 因为我某个点的最长路径要和上下左右四个防线比较的话
//我从上往下写循环，我下面的结果是没有求出来的，所以我要用记忆化搜索来写
public class LongestIncreasingSubsequenceII {
	public int longestIncreasingContinuousSubsequenceII(int[][] A]) {
		if (A.length == 0) {
			return 0;
		}
		int n = A.length;
		int m = A[0].length;
		int res = 0;
		int[] dp = new int[n][m];
		int[] flag = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				dp[i][j] = search(i, j, A);
				res = Math.max(res, dp[i][j]);
			}
		}
		int[] dx = new int[]{1, -1, 0, 0};
		int[] dy = new int[]{0, 0, 1, -1};
	}
	private int search(int x, int y, int[][] A) {
		if (flag[x][y] != 0) {
			return dp[x][y];
		}
		int ans = 1;
		
	}
}
