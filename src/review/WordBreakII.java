package review;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//output为空？
//先写出最基本的backtracking思路的代码 会出现TLE 再看重复操作在哪里 进行改进
//这么写超时了 那么如何改进？
public class WordBreakII {
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

//DFS的思路 DFS和backtracking一样吗？
/*
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
		if (s.length() == 0) {
			res.add("");
			return res;
		}
		for (int i = 1; i <= max && i <= s.length(); i++) {
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
*/


//别人的memorization DFS 的思路 用hashmap减少重复操作
/*
public List<String> wordBreak(String s, Set<String> wordDict) {
    return DFS(s, wordDict, new HashMap<String, LinkedList<String>>());
}       

// DFS function returns an array including all substrings derived from s.
List<String> DFS(String s, Set<String> wordDict, HashMap<String, LinkedList<String>>map) {
    if (map.containsKey(s)) 
        return map.get(s);
        
    LinkedList<String>res = new LinkedList<String>();     
    if (s.length() == 0) {
        res.add("");
        return res;
    }               
    for (String word : wordDict) {
        if (s.startsWith(word)) {
            List<String>sublist = DFS(s.substring(word.length()), wordDict, map);
            for (String sub : sublist) 
                res.add(word + (sub.isEmpty() ? "" : " ") + sub);               
        }
    }       
    map.put(s, res);
    return res;
}
*/
