package review;

public class LongestSubstringWithoutRepeatingCharacter {
	public int lengthOfLongestSubstring(String s) {
		if(s == null || s.length() == 0) {
			return 0;
		}
		int[] hash = new int[256];
		int left = 0;
		int right = 0;
		int max = Integer.MIN_VALUE;
		while (right < s.length()) {
			if (hash[s.charAt(right)] == 0) {
				hash[s.charAt(right)] ++;
				max = Math.max(max, right-left+1);
				right ++;
			} else if (hash[s.charAt(right)] == 1) {
				hash[s.charAt(right)] ++;
				//找重复元素的的位置
				while (hash[s.charAt(left)] < 2) {
					hash[s.charAt(left)] --;
					left ++;
				}
				hash[s.charAt(left)] --;
				//current substring from left+1 to right
				//length = right - left
				max = Math.max(max, right-left);
				left ++;
				right ++;
			}
		}
		return max;
	}
}


//之前第一遍做的时候别人的思路 但是以后substring的题目最好用sliding window！

//思路就是 对于每一个元素如果在hash map中出现的 我通过
//hash map 找到上一个出现过重复元素的位置 以及之前更新过得位置
//这个思路不是自己想到的 体会一下怎么想出这样的思路的
//我觉得是通过经验积累 以及问题转化
/*
public class LongestSubstring {
	public int lengthOfLongestSubstring(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		Map<Character, Integer> map = new HashMap<>();
		int j = 0;
		int result = 0;
		for (int i = 0; i < s.length(); i++) {
			if (map.containsKey(s.charAt(i))) {
				j = Math.max(j, map.get(s.charAt(i)) + 1);
			}
			map.put(s.charAt(i), i);
			result = Math.max(result, i - j + 1);
		}
		return result;
	}
}
*/
