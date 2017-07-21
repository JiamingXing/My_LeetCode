package review;

public class LongestPalindromicSubsequence {
	public int longestPalindromeSubseq(String s) {
		//state : 从i到j的子字符串的最长回文子序列
		int[][] dp = new int[s.length()][s.length()];
		for (int i = 0; i < s.length(); i++) {
			dp[i][i] = 1;
		}
		//这里怎么开始循环到哪里非常重要！！
		for (int i = s.length() - 2; i >= 0; i--) {
			for (int j = i+1; j < s.length(); j++) {
				dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
				if (s.charAt(i) == s.charAt(j)) {
					dp[i][j] = Math.max(dp[i][j], dp[i+1][j-1]+2);
				}
			}
		}
		return dp[0][s.length()-1];
	}
}
