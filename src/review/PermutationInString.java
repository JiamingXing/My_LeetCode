package review;
//sliding window
public class PermutationInString {
	public boolean checkInclusion(String s1, String s2) {
		if (s1 == null || s1 == null || s1.length() == 0 || s2.length() == 0 || s1.length() > s2.length()) {
			return false;
		}
		int[] hash = new int[26];
		for (int i = 0; i < s1.length(); i++) {
			hash[s1.charAt(i) - 'a'] ++;
			hash[s2.charAt(i) - 'a'] --;
		}
		if (isZero(hash)) {
			return true;
		}
		for (int i = s1.length(); i < s2.length(); i++) {
			hash[s2.charAt(i) - 'a'] --;
			hash[s2.charAt(i- s1.length()) - 'a'] ++;
			if (isZero(hash)) {
				return true;
			}
		}
		return false;
	}
	private boolean isZero(int[] hash) {
		for (int i = 0; i < hash.length ; i++) {
			if (hash[i] != 0) {
				return false;
			}
		}
		return true;
	}
}
