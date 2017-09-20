package slidingwindow;

public class LongestSubstringWithoutDuplicatingCharacters {
	public int lengthOfLongestSubstring(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		int[] hash = new int[256];
		int left = 0;
		int right = 0;
		int max = Integer.MIN_VALUE;
		while (right < s.length()) {
			hash[s.charAt(right)] ++;
			if (hash[s.charAt(right)] < 2) {
				max = Math.max(max, right - left + 1);
			} else {
				while (hash[s.charAt(right)] > 1) {
					hash[s.charAt(left)] --;
					left ++;
				}
			}
			right ++;
		}
		return max;
	}
}
