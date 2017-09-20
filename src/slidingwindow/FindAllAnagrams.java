package slidingwindow;

import java.util.ArrayList;
import java.util.List;

public class FindAllAnagrams {
	public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s == null || p == null || s.length() == 0 || p.length() == 0) {
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
