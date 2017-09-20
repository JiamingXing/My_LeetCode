package DynamicProgramming;
//先理解好题目意思
public class RegularExpressionMatching {
	public boolean isMatch(String s, String p) {
		if (s == null || p == null) {
            return false;
        }
        int m = s.length();
        int n = p.length();
        //state s的前i个字符和p的前j个字符是否match
        boolean[][] dp = new boolean[m+1][n+1];
        //initialize
        dp[0][0] = true;
        for (int j = 1; j <= n; j++) {
            if (p.charAt(j-1) == '*') {
                if (dp[0][j-1] || (j > 1 && dp[0][j-2])) {
                    dp[0][j] = true;
                }
            }
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '.') {
                    dp[i][j] = dp[i-1][j-1];
                }
                if (p.charAt(j-1) == '*') {
                    //* means zero preceding
                    if (s.charAt(i-1) != p.charAt(j-2) && p.charAt(j-2) != '.') {
                        dp[i][j] = dp[i][j-2];
                    } else {
                    	//首先大前提是第p的第j个字符是星，然后它的preceding char和s的第i个字符是匹配的
                    	//dp[i-1][j]表示前i-1和j是匹配的，而且第i个字符和*前面的字符相同或者是'.'再加一个前面的字符表示多个preceding char
                        //dp[i][j-1]表示*前面的字符(必然不是*)已经和当前的i匹配了 那就意味着代表1个之前的字符(加不加这个*都OK对于当前的ij来说)
                        //dp[i][j-2]表示zero preceding char
                        dp[i][j] = dp[i-1][j] || dp[i][j-1] || dp[i][j-2];
                    }
                }
            }
        }
        return dp[m][n];
	}
}
