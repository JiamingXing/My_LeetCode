package slidingwindow;

public class MinimumWindowSubstring {
	public String minWindow(String s, String t) {
		if (s == null || t == null || s.length() == 0 || t.length() == 0) {
			return "";
		}
		int[] hash = new int[256];
		for (int i = 0; i < t.length(); i++) {
			hash[t.charAt(i)] ++;
		}
		int count = t.length();
		int left = 0;
		int right = 0;
		int head = 0;
		int min = Integer.MAX_VALUE;
		while (right < s.length()) {
			char temp = s.charAt(right);
			if (hash[temp] > 0) {
				count --;
			}
			hash[temp] --;
			right ++;
			if (count == 0) {
				while (count == 0) {
					if (right - left < min) {
						min = right - left;
						head = left;
					}
					if (hash[s.charAt(left)] == 0) {
						count ++;
					}
					hash[s.charAt(left)] ++;
					left ++;
 				}
			}
		}
		return min == Integer.MAX_VALUE ? "" : s.substring(head, head+min); 
	}
}
