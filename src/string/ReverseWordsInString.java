package string;
//" 1"的case无法通过
//如果直接split(" ")的话前面有两个空格返回的数组长度等于3
public class ReverseWordsInString {
	public String reverseWords(String s) {
		//如果要通过 要这么改。。 看别人答案得到的
		//s.trim().split("\\s+")
		//trim()表示return a copy of this string with leading and trailing
		//white space removed
		// \\s+ 是regex expression 表示group所有的空格作为界定符
		String[] st = s.split(" ");
		for (int i = 0, j = st.length - 1; i < j; i++, j--) {
			String temp = st[i];
			st[i] = st[j];
			st[j] = temp;
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < st.length; i++) {
			
			if (i == st.length - 1) {
				sb.append(st[i]);
			} else {
				sb.append(st[i]).append(" ");
			}
		}
		return sb.toString();
	}

}
