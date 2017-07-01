package DynamicProgramming;
// LCS
//首先你要学会判断这是一道双序列的题
//state: dp[i][j]， 第一个序列的前i个char 和第二个序列的前j个char
//function： 如果第i个char和第j个char不相同的话：dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1])；
		 // 如果相同：dp[i][j] = Math.max(dp[i-1][j-1] + 1, dp[i-1][j], dp[i][j-1]);
//initialization:
//final solution: return dp[A.length()][B.length()];
public class LongestCommonSubsequence {
	public int LCS(String A, String B){
		
	}

}
