package review;
//这道题根据字典中单词的长度是否可以进一步优化？
import java.util.List;

public class WordBreakI {
	public boolean wordBreak(String s, List<String> wordDict) {
		//dp[i]表示s的前i个字符能否被word break
		boolean[] dp = new boolean[s.length()+1];
		//初始化 就想一个最简单的例子leetcode 我当i指向t的位置的时候我要满足
		//dp[0] && wordDict.conatains("leet") = true; -> dp[0] = true
		dp[0] = true;
		int len = 0;
		for (String word : wordDict) {
			len = Math.max(len, word.length());
		}
		for (int i = 1; i < dp.length; i++) {
			for (int j = i-len >= 0 ? i-len : 0; j < i; j++) {
				String st = s.substring(j, i);
				if (wordDict.contains(st) && dp[j]) {
					dp[i] = true;
					break;
				}
			}
		}
		return dp[dp.length - 1];
	}
}
