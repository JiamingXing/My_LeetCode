package review;

public class CountAndSay {
	public String countAndSay(int n) {
		String s = "1";
		for (int i = n - 1; i > 0; i --) {
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < s.length(); j++) {
				char temp = s.charAt(j);
				int repeatTime  = 1;
				while (j + 1 < s.length() && s.charAt(j+1) == temp) {
					repeatTime ++;
					j ++;
				}
				sb.append(repeatTime).append(temp);
			}
			s = sb.toString();
		}
		return s;
	}
}
