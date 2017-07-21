package review;

public class InterleavingString {
	public boolean isInterleave(String s1, String s2, String s3) {
		if (s1.length() + s2.length() != s3.length()) {
			return false;
		}
		//state : s1前i个字符和s2前j个字符是否是s3前i+j个字符的interleaving
		boolean[][] dp = new boolean[s1.length()+1][s2.length()+1];
		dp[0][0] = true;
		for (int i = 1; i <= s1.length(); i++) {
            if(s3.charAt(i - 1) == s1.charAt(i - 1) && dp[i - 1][0])
                dp[i][0] = true;
        }
        for (int j = 1; j <= s2.length(); j++) {
            if(s3.charAt(j - 1) == s2.charAt(j - 1) && dp[0][j - 1])
                dp[0][j] = true;
        }
        //s3的第i+j位是s1的还是s2的要做不同的分析
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if(((s3.charAt(i + j - 1) == s1.charAt(i - 1) && dp[i - 1][j]))
                    || ((s3.charAt(i + j - 1)) == s2.charAt(j - 1) && dp[i][j - 1]))
                dp[i][j] = true;
            }
        }
        return dp[s1.length()][s2.length()];
	}
}
