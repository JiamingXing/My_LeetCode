package review;

public class ValidPalindrome {
	public boolean isPalindrome(String s) {
		if (s == null || s.length() == 1) {
			return true;
		}
		String st = s.toLowerCase();
		int i = 0;
		int j = st.length() - 1;
		while (i <= j) {
			if (!Character.isLetterOrDigit(st.charAt(i))) {
				i ++;
			} else if (!Character.isLetterOrDigit(st.charAt(j))) {
				j --;
			} else {
				if (st.charAt(i) != st.charAt(j)) {
					return false;
				}
				i++;
				j--;
			}
		}
		return true;
	}
}
