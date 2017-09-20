package slidingwindow;

public class LongestSubstringWithAtMostTwoDistinctCharacters {
	public int lengthOfLongestSubstringTwoDistinct(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		int[] hash = new int[256];
		int difNum = 0;
		int left = 0;
		int right = 0;
		int max = Integer.MIN_VALUE;
		while (right < s.length()) {
			hash[s.charAt(right)] ++;
			if (hash[s.charAt(right)] == 1) {
				difNum ++;
			}
			right ++;
			if (difNum > 2) {
				while (difNum > 2) {
					if (hash[s.charAt(left)] == 1) {
						difNum --;
					}
					hash[s.charAt(left)] --;
					left ++;
				}
			}
			//max的更新永远是在difNum小于等于2的时候进行 所以我们放在移动left之后
			max = Math.max(max, right - left);
		}
		return max;
	}
}
