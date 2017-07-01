package review;
//怎么处理括号的问题
import java.util.Stack;

public class BasicCalculator {
	public int calculate(String s) {
		Stack<Integer> stack = new Stack<>();
		int sign = 1;
		int res = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (Character.isDigit(c)) {
				int sum = c - '0';
				while (i+1 < s.length() && Character.isDigit(s.charAt(i+1))) {
					sum = sum * 10 + s.charAt(i+1) - '0';
					i ++;
				}
				res += sum * sign;
			} else if (c == '+') {
				sign = 1;
			} else if (c == '-') {
				sign = -1;
			} else if (c == '(') { //碰到括号是新的计算的开始 把之前的结果存到stack里先
				stack.push(res);
				stack.push(sign);
				res = 0;
				sign = 1;
			} else if (c == ')') {
				res = res * stack.pop();
				res += stack.pop();
			}
		}
		return res;
	}	
}
