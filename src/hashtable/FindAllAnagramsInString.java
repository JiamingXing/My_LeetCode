package hashtable;

import java.util.ArrayList;
import java.util.List;
//学习 别人的 sliding window的思路 有一个模板在
public class FindAllAnagramsInString {
	public List<Integer> findAnagrams(String s, String p) {
		List<Integer> res = new ArrayList<>();
		if(s == null || p == null || s.length() == 0 || p.length() == 0) {
			return res;
		}
		int[] hash = new int[256];
        for (char c : p.toCharArray()) {
            hash[c] ++;
        }
        int left = 0;
        int right = 0;
        int count = p.length();
        while (right < s.length()) {
            if (hash[s.charAt(right)] >= 1) {
                count --;
            }
            hash[s.charAt(right)] --;
            right ++;
            //count = 0 的时候说明当前left到right的区间内肯定包含p的全部chars
            //我们开始移动left每次都check right - left是否等于p的长度
            //如果等于p的长度说明满足条件 当前left-right的substring是p的anagram
            if (count == 0) {
                while (count == 0) {
                    if (right - left == p.length()) {
                        res.add(left);
                    }
                    if (hash[s.charAt(left)] == 0) {
                        count ++;
                    }
                    hash[s.charAt(left)] ++;
                    left ++;
                }
            }
        }
        return res;
	}
}
