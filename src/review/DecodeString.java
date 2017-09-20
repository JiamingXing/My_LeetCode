package review;

import java.util.Stack;
//这道题随便找个例子按照顺序看看怎么排列的 能不能想到用stack先进后出的性质来做
//自己review的时候第二遍做这道题有思路但是很难把代码写出来
public class DecodeString {
	public String decodeString(String s) {
		Stack<String> stringStack = new Stack<>();
		Stack<Integer> intStack = new Stack<>();
		String res = "";
		int index = 0;
		while (index < s.length()) {
			if (Character.isDigit(s.charAt(index))) {
				int dig = 0;
				while(Character.isDigit(s.charAt(index))) {
					dig = dig * 10 + (s.charAt(index) - '0');
					index ++;
				}
				intStack.push(dig);
			} else if (s.charAt(index) == '[') {
				stringStack.push(res);
				res = "";
				index++;
			} else if (s.charAt(index) == ']') {
				//这一步是最关键的 我碰到']'的时候需要先出栈之前入栈的字符和当前的字符黏贴
				StringBuilder temp = new StringBuilder(stringStack.pop());
				int repeatTime = intStack.pop();
				while (repeatTime > 0) {
					temp.append(res);
					repeatTime --;
				}
				res = temp.toString();
				index++;
			} else {
				res += s.charAt(index);
				index ++;
			}
		}
		return res;
	}

}
