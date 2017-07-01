package review;

public class ReverseWordsInaStringIII {
	public String reverseWords(String s) {
		String[] st = s.split(" ");
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < st.length; i++) {
			String temp = swap(st[i]);
			sb.append(temp);
			if (i != st.length - 1) {
				sb.append(' ');
			}
		}
		return sb.toString();
	}
	private String swap(String s) {
		char[] ch = s.toCharArray();
		for (int i = 0, j = ch.length - 1; i < j; i++, j--) {
			char temp = ch[i];
			ch[i] = ch[j];
			ch[j] = temp;
		}
//		return ch.toString();
		return String.valueOf(ch);
	}
}
