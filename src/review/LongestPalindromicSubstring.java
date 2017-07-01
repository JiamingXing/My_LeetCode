package review;
//brute force的做法 但是会超时 如何改进？
public class LongestPalindromicSubstring {
	int max = Integer.MIN_VALUE;
	public String longestPalindrome(String s) {
		if (s == null || s.length() == 0) {
			return null;
		}
		String res = s.substring(0, 1);
		if (s.length() == 1) {
			return res;
		}
		char[] ch = s.toCharArray();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < ch.length; i ++) {
			sb.append('#');
			sb.append(ch[i]);
			if (i == ch.length - 1) {
				sb.append('#');
			}
		}
		String temp = sb.toString();
		for (int i = 1; i < temp.length() - 1; i ++) {
			int start = i - 1;
			int end = i + 1;
			while (start >= 0 && end <= temp.length() - 1) {
				if (temp.charAt(start) != temp.charAt(end)) {
					break;
				}
				start --;
				end ++;
			}
			int len = (end - start - 2) / 2;
			if (len > max) {
				max = len;
				int newStart = (start + 1) / 2;
				int newEnd = (end - 3) / 2;
				res = s.substring(newStart, newEnd + 1);
			}
		}
		return res;
	}
}
/*
public class Solution {
private int lo, maxLen;

public String longestPalindrome(String s) {
	int len = s.length();
	if (len < 2)
		return s;
	
    for (int i = 0; i < len-1; i++) {
     	extendPalindrome(s, i, i);  //assume odd length, try to extend Palindrome as possible
     	extendPalindrome(s, i, i+1); //assume even length.
    }
    return s.substring(lo, lo + maxLen);
}

private void extendPalindrome(String s, int j, int k) {
	while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
		j--;
		k++;
	}
	if (maxLen < k - j - 1) {
		lo = j + 1;
		maxLen = k - j - 1;
	}
}}
*/



/*
public class LongestPalindromicSubstring {
	int max = Integer.MIN_VALUE;
	public String longestPalindrome(String s) {
		if (s == null || s.length() == 0) {
			return null;
		}
		String res = s.substring(0, 1);
		if (s.length() == 1) {
			return res;
		}
		for (int i = 0; i < s.length() - 1; i ++) {
			int j = i + 1;
			while (j < s.length()) {
				if (s.charAt(i) == s.charAt(j)) {
					if (isPalindrom(s, i, j)) {
						if (max < j - i + 1) {
							max = j -i + 1;
							res = s.substring(i, j+1);
						}
					}
				}
				j ++;
			}
		}
		return res;
	}
	private boolean isPalindrom(String s, int start, int end) {
		while (start < end) {
			if (s.charAt(start) != s.charAt(end)) {
				return false;
			}
			start ++;
			end --;
		}
		return true;
	}
}
*/
