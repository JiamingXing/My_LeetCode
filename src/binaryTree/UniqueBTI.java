package binaryTree;
//DP
public class UniqueBTI {
	public int numTrees(int n) {
		int[] dp = new int[n + 1];
		dp[0] = 1;
		dp[1] = 1;
		for (int i = 2; i <= n; i++) {
			int temp = 0;
			for (int j = 1; j <= i; j++) {
				temp += dp[i-j] * dp[j-1];
			}
			dp[i] = temp;
		}
		return dp[n];
	}

}
