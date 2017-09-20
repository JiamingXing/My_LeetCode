package DynamicProgramming;



//这个在值比较大的时候TLE了，需要记忆化搜索来减少重复操作
//TLE again
public class OutofBoundaryPaths {
	private static final int mod = 1000000007;
	private static final int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};
	public int findPaths(int m, int n, int N, int i, int j) {
		if (N == 0) {
			return 0;
		}
		int[][][] dp = new int[m][n][N];
		return helper(m, n, N, i, j, dp);
	}
	private int helper(int m, int n, int N, int i, int j, int[][][] dp) {
		if (dp[i][j][N] != 0) {
			return dp[i][j][N];
		}
		int res = 0;
		if (N == 1) {
			for (int[] dir : dirs) {
				int row = i + dir[0];
				int col = j + dir[1];
				if (row < 0 || col < 0 || row >= m || col >= n) {
					res ++;
				}
			}
			dp[i][j][N] = res % mod;
			return res % mod;
		}
		for (int[] dir : dirs) {
			int row = i + dir[0];
			int col = j + dir[1];
			if (row < 0 || col < 0 || row >= m || col >= n) {
				res ++;
			} else {
				res += helper(m, n, N-1, row, col, dp);
			}
		}
		dp[i][j][N] = res % mod;
		return res % mod;
	}
}

/*
//这个在值比较大的时候TLE了，需要记忆化搜索来减少重复操作
public class OutofBoundaryPaths {
	public int mod = 100000007;
	private static final int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};
	public int findPaths(int m, int n, int N, int i, int j) {
		if (N == 0) {
			return 0;
		}

		return helper(m, n, N, i, j);
	}
	private int helper(int m, int n, int N, int i, int j) {
		int res = 0;
		if (N == 1) {
			for (int[] dir : dirs) {
				int row = i + dir[0];
				int col = j + dir[1];
				if (row < 0 || col < 0 || row >= m || col >= n) {
					res ++;
				}
			}
			return res % mod;
		}
		for (int[] dir : dirs) {
			int row = i + dir[0];
			int col = j + dir[1];
			if (row < 0 || col < 0 || row >= m || col >= n) {
				res ++;
			} else {
				res += helper(m, n, N-1, row, col);
			}
		}
		return res % mod;
	}
}
*/
