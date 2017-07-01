package review;
//这道题不能按部就班的来 要用一些已经写在API中的方法
public class DetectCapital {
	public boolean detectCapitalUse(String word) {
		if (word.length() < 2) {
			return true;
		}
		char[] ch = word.toCharArray();
		int i = 2;
		if (Character.isUpperCase(ch[0])) {
			if (Character.isUpperCase(ch[1])) {
				while (i < ch.length) {
					if (!Character.isUpperCase(ch[i])) {
						return false;
					}
					i ++;
				}
			} else {
				while (i < ch.length) {
					if (Character.isUpperCase(ch[i])) {
						return false;
					}
					i ++;
				}
			}
		} else {
			for (int j = 1; j < ch.length; j++) {
				if (Character.isUpperCase(ch[j])) {
					return false;
				}
			}
		}
		return true;
	}
}
/*
public class Solution {
    public boolean detectCapitalUse(String word) {
        return word.equals(word.toUpperCase()) ||
				word.equals(word.toLowerCase()) ||
				Character.isUpperCase(word.charAt(0)) &&
				word.substring(1).equals(word.substring(1).toLowerCase());
    }
}
*/
