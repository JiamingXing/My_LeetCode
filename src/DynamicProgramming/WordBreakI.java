package DynamicProgramming;

import java.util.List;

public class WordBreakI {
	public boolean wordBreak(String s, List<String> wordDict) {
		if (s == null || s.length() == 0) {
			return false;
		}
		int min = 0;
		int max = 0;
		for (String word : wordDict) {
			min = Math.min(min, word.length());
			max = Math.max(max, word.length());
		}
		//state dp[i]s的前i个字符能否被word break
		boolean[] dp = new boolean[s.length() + 1];
		dp[0] = true;
		for (int i = 1; i < dp.length; i++) {
			for (int j = i-max >= 0 ? (i-max) : 0; j < i; j++) {
				String cur = s.substring(j, i);
				if (wordDict.contains(cur) && dp[j]) {
					dp[i] = true;
					break;
				}
			}
		}
		return dp[dp.length - 1];
	}
}
