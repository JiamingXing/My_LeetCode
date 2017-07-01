package string;

public class RepeatedSubStringPattern {
	public boolean repeatedSubstringPattern(String s) {
		for (int i =  1; i <= s.length()/2; i++) {
			if (s.length() % i == 0) {
				int num = s.length() / i;
				StringBuilder sb = new StringBuilder();
				String st = s.substring(0, i);
				for (int j = 0; j < num; j++) {
					sb.append(st);
				}
				if (sb.toString().equals(s)) {
					return true;
				}
			}
		}
		return false;
	}

}
