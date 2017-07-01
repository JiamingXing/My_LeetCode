package review;

import java.util.HashMap;
import java.util.Map;

public class WordPatternReview {
	public boolean wordPattern(String pattern, String str) {
		Map<Character, String> map = new HashMap<>();
		String[] st = str.split(" ");
		if (st.length != pattern.length()) {
			return false;
		}
		for (int i = 0; i < pattern.length(); i++) {
			char c = pattern.charAt(i);
			if (map.containsKey(c)) {
				if (!map.get(c).equals(st[i])) {
					return false;
				}
			} else if (map.containsValue(st[i])) {
				return false;
			}
		}
		return true;
	}
}

//之前写的一个错误的版本，还是对一些特殊的test case考虑不够细致
//比如 pattern: abba str: dog dog dog dog
//这种情况是可以满足这样的写法的但是会出错因为我只考虑了相同pattern对应字符之间的关系
//没有考虑不同字符对应的必须不同字符串这一点
/*
public class Solution {
    public boolean wordPattern(String pattern, String str) {
        String[] words = str.split(" ");
		if(words.length != pattern.length()) {
			return false;
		}
		Map<Character, String> map = new HashMap<>();
		for(int i = 0; i < words.length; i ++) {
			if(map.containsKey(pattern.charAt(i))) {
				if(!map.get(pattern.charAt(i)).equals(words[i])){
					return false;
				}
			}else{
				map.put(pattern.charAt(i), words[i]);
			}
		}
		return true;
    }
}
*/
