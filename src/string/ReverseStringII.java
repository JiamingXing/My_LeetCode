package string;

public class ReverseStringII {
	public String reverseStr(String s, int k) {
		char[] ch = s.toCharArray();
		int l = ch.length;
		int i = 0;
		while (i < l) {
			int j = Math.min(l - 1, i + k - 1);
			reverse(ch, i, j);
			i = i + 2 * k;
		}
		//一开始使用 toString 发现出来的结果是乱七八糟的东西
		//因为toString returns a string representation of contents in the array
		//return ch.toString();
		return String.valueOf(ch);
	}
	public void reverse(char[] ch, int start, int end) {
		while (start < end) {
			char temp = ch[start];
			ch[start] = ch[end];
			ch[end] = temp;
			start ++;
			end --;
		}
	}

}
