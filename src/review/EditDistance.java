package review;

public class EditDistance {
	public int minDistance(String word1, String word2) {
		//state：dp[i][j]word1的前i个字符至少需要几次操作变成word2的前j个字符
		int[][] dp = new int[word1.length()+1][word2.length()+1];
		for (int i = 0; i <= word1.length(); i++) {
			dp[i][0] = i;
		}
		for (int i = 0; i <= word2.length(); i++) {
			dp[0][i] = i;
		}
		for (int i = 1; i <= word1.length(); i++) {
			for (int j = 1; j <= word2.length(); j++) {
				//不管哪种情况都先考虑增删两种情况 [i][j-1]为增 [i-1][j]为删
				dp[i][j] = Math.min(dp[i][j-1]+1, dp[i-1][j]+1);
				if (word1.charAt(i-1) == word2.charAt(j-1)) {
					dp[i][j] = Math.min(dp[i][j], dp[i-1][j-1]);
				} else {
					dp[i][j] = Math.min(dp[i-1][j-1] + 1, dp[i][j]);
				}
			}
		}
		return dp[word1.length()][word2.length()];
	}
}
