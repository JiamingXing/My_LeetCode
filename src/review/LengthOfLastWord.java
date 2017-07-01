package review;

public class LengthOfLastWord {
	public int lengthOfLastWord(String s) {
		int i = s.length() - 1;
		while (i >= 0 && s.charAt(i) == ' ') {
			i --;
		}
		int res = 0;
		while (i >= 0 && s.charAt(i) != ' ') {
			i --;
			res ++;
		}
		return res;
	}
}
/*
public class Solution {
    public int lengthOfLastWord(String s) {
        String[] st = s.split(" ");
        if (st.length == 0) {
            return 0;
        }
        return st[st.length - 1].length();
    }
}
*/


/* 
public int lengthOfLastWord(String s) {
    return s.trim().length()-s.trim().lastIndexOf(" ")-1;
}
*/