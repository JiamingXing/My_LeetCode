package review;

public class ReverseStringII {
	public String reverseStr(String s, int k) {
		char[] ch = s.toCharArray();
		int i = 0;
		int l = ch.length;
		while (i < l) {
			int j = Math.min(l - 1, i + k - 1);
			reverse(ch, i, j);
			i = i + 2 * k;
		}
		return String.valueOf(ch);
	}
	private void reverse(char[] ch, int start, int end) {
		while (start < end) {
			char temp = ch[start];
			ch[start] = ch[end];
			ch[end] = temp;
			start ++;
			end --;
		}
	}
}
