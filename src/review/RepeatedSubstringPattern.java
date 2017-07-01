package review;
//从1还是0开始 小于等于还是小于 要自己试几个例子搞清楚
public class RepeatedSubstringPattern {
	public boolean repeatedSubstringPattern(String s) {
		for (int i = 1; i <= s.length() /2 ; i++) {
			StringBuilder sb = new StringBuilder();
			String temp = s.substring(0, i);
			int repeatTime = s.length() / temp.length();
			if (s.length() % temp.length() != 0) {
				continue;
			}
			for (int j = 1; j <= repeatTime; j++) {
				sb.append(temp);
			}
			if (sb.toString().equals(s)) {
				return true;
			}
		}
		return false;
	}
}
