package stack;
//为什么可以想到用stack来做？ 因为我碰到']' 我需要得到最近的字符以及数字
//也就是后进stack的东西 可以先出来
//思路不是自己想出来的。。
//如何转换DFS的思想 如何把stack 先进后出的思想和DFS的思想联系起来
import java.util.Stack;

public class DecodeString {
	public String decodeString(String s) {
		Stack<Integer> intStack = new Stack<>();
		Stack<String> stringStack = new Stack<>();
		String result = "";
		int index = 0;
		while (index < s.length()) {
			if (Character.isDigit(s.charAt(index))) {
				int dig = 0;
				while (Character.isDigit(s.charAt(index))) {
					dig = dig *10 + (s.charAt(index) - '0');
					index ++;
				}
				intStack.push(dig);
				//一开始考虑碰到'['的时候不知道该进行什么操作
				//这一步的思路是怎么形成的
			} else if (s.charAt(index) == '[' ) {
				stringStack.push(result);
				result = "";
				index ++;
			} else if (s.charAt(index) == ']') {
				StringBuilder temp = new StringBuilder(stringStack.pop());
				int repeatTime = intStack.pop();
				while (repeatTime > 0) {
					temp.append(result);
					repeatTime --;
				}
				result = temp.toString();
				index ++;
			} else {
				result += s.charAt(index);
				index ++;
			}
		}
		return result;
	}
}


//简介版的程序
/*
Stack<Integer> intStack = new Stack<>();
Stack<StringBuilder> strStack = new Stack<>();
StringBuilder cur = new StringBuilder();
int k = 0;
for (char ch : s.toCharArray()) {
    if (Character.isDigit(ch)) {
        k = k * 10 + ch - '0';
    } else if ( ch == '[') {
        intStack.push(k);
        strStack.push(cur);
        cur = new StringBuilder();
        k = 0;
    } else if (ch == ']') {
        StringBuilder tmp = cur;
        cur = strStack.pop();
        for (k = intStack.pop(); k > 0; --k) cur.append(tmp);
    } else cur.append(ch);
}
return cur.toString();
*/