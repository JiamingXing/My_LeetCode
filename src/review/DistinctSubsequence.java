package review;
//Given a string S and a string T 
//count the number of distinct subsequences of S which equals T.
public class DistinctSubsequence {
	public int numDistinct(String s, String t) {
		//state : S的前i个字符中选取T的前j个字符有多少方案
		int[][] dp = new int[s.length()+1][t.length()+1];
		for (int i = 0; i <= s.length(); i++) {
			dp[i][0] = 1;
		}
		//这一步初始化时多余的 定义也可以但是dp[0][0]不能定义进去不然会出错
//		for (int i = 0; i <= t.length(); i++) {
//			dp[0][i] = 0;
//		}
		for (int i = 1; i <= s.length(); i++) {
			for (int j = 1; j <= t.length(); j++) {
				if (s.charAt(i-1) == t.charAt(j-1)) {
					//dp[i-1][j]这种情况很有可能没考虑
					dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
				} else {
					dp[i][j] = dp[i-1][j];
				}
			}
		}
		return dp[s.length()][t.length()];
	}
}
