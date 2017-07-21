package review;
//给出两个字符串，找出他们的最长公共子序列(LCS)，返回LCS的长度
//"ABCD" "EDCA" -> "A" or " D" "C" return 1
//"ABCD" "EACB" -> "AB" return 2
//LIS : Longest Increasing Subsequence 坐标型动态规划 有时间做一下
public class LongestCommonSubsequence {
	public int longestCommonSubsequence(String A, String B) {
		//f[i][j] 代表第一个字符串的前i个字符和第二个字符串的前j个字符
		//f[][]
		int[][] dp = new int[A.length()+1][B.length()+1];
		for (int i = 0; i <= A.length(); i++) {
			dp[i][0] = 0;
		}
		for (int i = 0; i <= B.length(); i++) {
			dp[0][i] = 0;
		}
		for (int i = 1; i <= A.length(); i++) {
			for (int j = 1; j <= B.length(); j++) {
				//这里如果出现最后一位字符相同的情况，结果是不是就一定是f[i-1][j-1] +1?
				//感觉是但是如果不确定的话，我大不了一样考虑不要最后一位的情况，反正都是取最大
				if (A.charAt(i-1) == B.charAt(j-1)) {
					dp[i][j] = dp[i-1][j-1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
				//不确定的时候就双重保险，也不会出错
//				dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
//				if (A.charAt(i-1) == B.charAt(j-1)) {
//					dp[i][j] = Math.max(dp[i][j], dp[i-1][j-1]+1);
//				}
			}
		}
		return dp[A.length()][B.length()];
	}
}
