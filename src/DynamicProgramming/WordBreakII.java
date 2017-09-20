package DynamicProgramming;

import java.util.ArrayList;
import java.util.List;
//这道题TLE的写法至少要自己写出来 再加一个hashtable 记忆化搜索就是正确的版本
public class WordBreakII {
	public List<String> wordBreak(String s, List<String> wordDict) {
		int max = 0;
		for (String word : wordDict) {
			max = Math.max(max, word.length());
		}
		return helper(s, wordDict, max);
	}
	private List<String> helper(String s, List<String> wordDict, int max) {
		List<String> res = new ArrayList<>();
		//为了区分单词
		if (s.length() == 0) {
			res.add("");
			return res;
		}
		for (int i = 1; i <= max; i++) {
			//前i个字符
			String temp = s.substring(0, i);
			if (wordDict.contains(temp)) {
				List<String> sublist = helper(s.substring(i), wordDict, max);
				for (String ss : sublist) {
					res.add(temp + (ss.isEmpty() ? "" : " ") + ss);
				}
			}
		}
		return res;
	}
}

/*
public class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        int max = 0;
		for (String word : wordDict) {
			max = Math.max(max, word.length());
		}
		Map<String, List<String>> map = new HashMap<>();
		return helper(s, wordDict, map, max);
    }
    private List<String> helper(String s, List<String> wordDict, Map<String, List<String>> map, int max) {
		if (map.containsKey(s)) {
			return map.get(s);
		}
		List<String> res = new ArrayList<>();
		if (s.length() == 0) {
			res.add("");
			return res;
		}
		for (int i = 1; i <= max && i <= s.length(); i++) {
			String temp = s.substring(0, i);
			if (wordDict.contains(temp)) {
				List<String> sublist = helper(s.substring(i), wordDict, map, max);
				for (String ss : sublist) {
					res.add(temp + (ss.isEmpty() ? "" : " ") + ss);
				}
			}
		}
		map.put(s, res);
		return res;
	}
}
*/
