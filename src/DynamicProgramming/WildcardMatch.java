package DynamicProgramming;

public class WildcardMatch {
	public boolean isMatch(String s, String p) {
		if (s == null || p == null) {
            return false;
        }
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m+1][n+1];
        dp[0][0] = true;
        for (int i = 1; i <= n; i++) {
            dp[0][i] = p.charAt(i-1) == '*' && dp[0][i-1];
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j ++) {
                if (s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '?') {
                    dp[i][j] = dp[i-1][j-1];
                }
                if (p.charAt(j-1) == '*') {
                  //dp[i][j-1]表示empty sequence dp[i-1][j]表示加一个s的第i个字符
                	dp[i][j] = dp[i-1][j] || dp[i][j-1];
                }
            }
        }
        return dp[m][n];
    }
}
