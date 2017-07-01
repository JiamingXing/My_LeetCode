package string;
//通过一些easy的题熟悉对 String char stringbuilder的基本操作
//多查API
public class ReverseWordsInStringIII {
	public String reverseWords(String s) {
		String[] str = s.split(" ");
		StringBuilder res = new StringBuilder();
		for(int i = 0; i < str.length; i++) {
			String st = reverse(str[i]);
			res.append(st);
			if (i != str.length - 1) {
				res.append(' ');
			}
		}
		return res.toString();
	}
	//为什么void 这样写不行？？？ 很关键的错误
	//因为String 是immutable的 所以我在这里 当我将st传入这个reverse函数的时候
	//有一个local variable s是指向 st的 但是因为string的特性 当我在函数里
	//修改s指向的内容的时候 s指向了一个新的string obj 而st还是指向原来的string obj
	//没有进行修改 这是因为String的特性非常关键！！！！！！！ 一定要记住
//	private void reverse(String s) {
//		char[] ch = s.toCharArray();
//		int start = 0;
//		int end = ch.length - 1;
//		while(start < end) {
//			char temp = ch[start];
//			ch[start] = ch[end];
//			ch[end] = temp;
//			start ++;
//			end --;
//		}
//		//s = ch.toString();
//		s = String.valueOf(ch);
//	}
	private String reverse(String s) {
		char[] ch = s.toCharArray();
		int start = 0;
		int end = ch.length - 1;
		while(start < end) {
			char temp = ch[start];
			ch[start] = ch[end];
			ch[end] = temp;
			start ++;
			end --;
		}
		//s = ch.toString();
		return String.valueOf(ch);
	}

}
