package hashtable;

public class LongestSubstringwithAtMostTwoDistinctCharacters {
	public int lengthOfLongestSubstringTwoDistinct(String s) {
		if (s == null || s.length() == 0){
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
			max = Math.max(max, right - left);
		}
		return max;
	}
}
