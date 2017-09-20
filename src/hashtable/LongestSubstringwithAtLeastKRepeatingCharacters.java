package hashtable;
//100ms 很慢的暴力解
public class LongestSubstringwithAtLeastKRepeatingCharacters {
	public int longestSubstring(String s, int k) {
        char[] str = s.toCharArray();
        return helper(str, 0, s.length(), k);
    }
	private int helper(char[] str, int start, int end, int k) {
		if (end - start < k) {
			return 0;
		}
		int[] hash = new int[26];
		for (int i = start; i < end; i++) {
			hash[str[i] - 'a'] ++;
		}
		for (int i = 0; i < 26; i++) {
			if (hash[i] < k && hash[i] != 0) {
				for (int j = start; j < end; j++) {
					if (str[j] == i + 'a') {
						int left = helper(str, start, j, k);
						int right = helper(str, j+1, end, k);
						return Math.max(left, right);
					}
				}
			}
		}
		return end - start;
	}
}




//TLE
/*
public class LongestSubstringwithAtLeastKRepeatingCharacters {
	public int longestSubstring(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        return helper(s, map, k);
    }
    private int helper(String s, Map<Character, Integer> map, int k) {
        int count = 0;
        int total = map.keySet().size();
        for (char c : map.keySet()) {
            if (map.get(c) >= k) {
                count ++;
            }
        }
        if (count == total) {
            return s.length();
        } else if (count == 0) {
            return 0;
        }
        int index = 0;
        int max = 0;
        while (index < s.length()) {
            if (map.get(s.charAt(index)) < k) {
                int left = 0;
                if (index == 0) {
                    left = 0;
                } else {
                    Map<Character, Integer> leftMap = new HashMap<>();
                    for (int i = 0; i < index; i++) {
                        leftMap.put(s.charAt(i), leftMap.getOrDefault(s.charAt(i), 0) + 1);
                    }
                    String leftString = s.substring(0, index);
                    left = helper(leftString, leftMap, k);
                }
                int right = 0;
                if (index == s.length() - 1) {
                    right = 0;
                } else {
                    Map<Character, Integer> rightMap = new HashMap<>();
                    for (int j = index + 1; j < s.length(); j++) {
                        rightMap.put(s.charAt(j), rightMap.getOrDefault(s.charAt(j), 0) + 1);
                    }
                    String rightString = s.substring(index + 1);
                    right = helper(rightString, rightMap, k);
                }
                max = Math.max(left, right);
                break;
            }
            index ++;
        }
        return max;
    }
}
*/
