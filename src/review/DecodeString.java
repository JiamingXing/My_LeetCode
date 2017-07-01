package review;

import java.util.Stack;

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
