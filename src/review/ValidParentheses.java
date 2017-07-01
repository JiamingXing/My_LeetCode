package review;

import java.util.Stack;

//这道题为什么会想到用stack做这是很关键的一个问题
public class ValidParentheses {
	public boolean isValid(String s) {
		if (s.length() == 0 && s.length() % 2 != 0) {
			return false;
		}
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '(') {
				stack.push(')');
			} else if (c == '[') {
				stack.push(']');
			} else if (c == '{') {
				stack.push('}');
			} else if (stack.isEmpty() || !stack.peek().equals(c)) {
				return false;
			}
		}
		return true;
	}

}
