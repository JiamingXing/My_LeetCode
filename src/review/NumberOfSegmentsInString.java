package review;

public class NumberOfSegmentsInString {
	public int countSegments(String s) {
		char[] ch = s.toCharArray();
		int res = 0;
		for (int i = 0; i < ch.length; i++) {
			char c = ch[i];
			if (c != ' ') {
				while (i + 1 < ch.length && ch[i+1] != ' ') {
					i++;
				}
				res ++;
			}
		}
		return res;
	}
}
