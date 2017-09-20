package hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SubstringwithConcatenationofAllWords {
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
			map.put(word, 1);
		}
		for (int i = left; i <= right - lenPerWord; i += lenPerWord) {
			String cur = s.substring(i, i + lenPerWord);
			if (map.containsKey(cur) && map.get(cur) == 1) {
				count ++;
				map.put(cur, 0);
			}
		}
		if (count == words.length) {
			return true;
		}
		return false;
	}
}
