package hashtable;

import java.util.HashMap;
import java.util.Map;
//这道题因为自己的粗心 错了有7 8 次了吧。。真的得自己好好审题检查
//速度也是有点慢 看看别人的做法
public class LongestPalindrome {
	public int longestPalindrome(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		Map<Character, Integer> map = new HashMap<>();
		for (char c : s.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0)+1);
		}
		int res = 0;
		int tag = 0;
		for (char key : map.keySet()) {
			if (map.get(key) % 2 == 0) {
				res += map.get(key);
			} else {
				res += map.get(key) - 1;
				tag = 1;
			}
		}
		if (tag == 1) {
			res ++;
		}
		return res;
	}
}

/*
public class Solution {
    public int longestPalindrome(String s) {
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (set.contains(c)) set.remove(c);
            else set.add(c);
        }

        int odd = set.size();
        return s.length() - (odd == 0 ? 0 : odd - 1);
    }
}
*/