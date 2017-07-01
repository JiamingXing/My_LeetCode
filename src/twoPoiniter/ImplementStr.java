package twoPoiniter;

public class ImplementStr {
	public int strStr(String haystack, String needle) {
		for (int i = 0; i <= haystack.length() - needle.length(); i++) {
			int j = i + needle.length();
			if (haystack.substring(i, j).equals(needle)) {
				return i;
			}
		}
		return -1;
	}
}
