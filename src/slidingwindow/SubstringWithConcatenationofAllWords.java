package slidingwindow;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubstringWithConcatenationofAllWords {
	public List<Integer> findSubstring(String s, String[] words) {
		List<Integer> res = new ArrayList<>();
		if (s == null || s.length() < words.length * words[0].length()) {
			return res;
		}
		int m = s.length();
		int n = words.length;
		int pl = words[0].length();
		Map<String, Integer> map = new HashMap<>();
		Map<String, Integer> curMap = new HashMap<>();
		for (String word : words) {
			map.put(word, map.getOrDefault(word, 0) + 1);
		}
		String str = null;
		String temp = null;
		for (int i = 0; i < pl; i++) {
			int count = 0;
			int start = i;
			for (int j = i; j + pl <= m; j += pl) {
				str = s.substring(j, j + pl);
				if (map.containsKey(str)) {
					curMap.put(str, curMap.getOrDefault(str, 0) + 1);
					if (curMap.get(str) <= map.get(str)) {
						count ++;
					}
					while (curMap.get(str) > map.get(str)) {
						temp = s.substring(start, start + pl);
						curMap.put(temp, curMap.get(temp) - 1);
						start += pl;
						if (curMap.get(str) < map.get(str)) {
							count --;
						}
					}
					if (count == n) {
						res.add(start);
						temp = s.substring(start, start+pl);
						curMap.put(temp, curMap.get(temp) - 1);
						start += pl;
						count --;
					}
				} else {
					curMap.clear();
					count = 0;
					start = j + pl;
				}
			}
			curMap.clear();
		}
		return res;
	}
}





//一开始自己写的没过的版本 TLE
//虽然还是用sliding window的模板加思路
/*
class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        int[] hash = new int[256];
        int count = 0;
        int sum = 0;
        for (String word : words) {
            for (char c : word.toCharArray()) {
                hash[c] ++;
                count ++;
                sum ++;
            }
        }
        int left = 0;
        int right = 0;
        while (right < s.length()) {
            if (hash[s.charAt(right)] >= 1) {
                count --;
            }
            hash[s.charAt(right)] --;
            right ++;
            if (count == 0) {
                while (count == 0) {
                	//这一部分是关键怎么这道符合concatenate all words
                    if (right - left == sum) {
                        if (isValid(s, words, left, right)) {
                        	res.add(left);
                        }
                    }
                    if (hash[s.charAt(left)] >= 0) {
                        count ++;
                    }
                    hash[s.charAt(left)] ++;
                    left ++;
                }
            }
        }
        return res;
    }
    private boolean isValid(String s, String[] words, int left, int right) {
		HashMap<String, Integer> map = new HashMap<>();
		int lenPerWord = words[0].length();
		int count = 0;
		for (String word : words) {
			map.put(word, map.getOrDefault(word, 0) + 1);
		}
		for (int i = left; i <= right - lenPerWord; i += lenPerWord) {
			String cur = s.substring(i, i + lenPerWord);
			if (map.containsKey(cur) && map.get(cur) > 0) {
				count ++;
				map.put(cur, map.get(cur) - 1);
			}
		}
		if (count == words.length) {
			return true;
		}
		return false;
	}
}
*/