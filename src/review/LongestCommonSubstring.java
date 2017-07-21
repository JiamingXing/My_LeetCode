package review;

public class LongestCommonSubstring {
	public int longestCommonSubstring(String A, String B) {
		//最直接的想法 用indexOf解决
//		int res = 0;
//		for (int i = 0; i < A.length(); i ++) {
//			for (int j = i+1; j <= A.length(); j ++) {
//				String s = A.substring(i, j);
//				if (B.indexOf(s) != -1) {
//					res = Math.max(res, s.length());
//				}
//			}
//		}
//		return res;
		//如果使用DP
		int max = 0;
		int[][] dp = new int[A.length()+1][B.length()+1];
		for (int i = 1; i <= A.length(); i++) {
			for (int j = 1; j <= B.length(); j++) {
				if (A.charAt(i-1) == B.charAt(j-1)) {
					dp[i][j] = dp[i-1][j-1] + 1;
				} else {
					dp[i][j] = 0;
				}
				max = Math.max(max, dp[i][j]);
			}
		}
		return max;
	}
}
