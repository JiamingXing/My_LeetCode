package stack;

import java.util.Stack;

//这道题关键在于怎么想到能用stak解决
//如果这道题不用list 该怎么做？
public class One32Pattern {
	public class Pair {
		int max;
		int min;
		public Pair(int max, int min) {
			this.max = max;
			this.min = min;
		}
	}
	public boolean find132pattern(int[] nums) {
		Stack<Pair> stack = new Stack<>();
		for (int n : nums) {
			if (stack.isEmpty() || n < stack.peek().min) {
				stack.push(new Pair(n, n));
			} else if (n > stack.peek().min) {
				Pair last = stack.pop();
				if (n < last.max) {
					return true;
				} else {
					last.max = n;
					while (!stack.isEmpty() && n >= stack.peek().max) {
						stack.pop();
					}
					if (!stack.isEmpty() && stack.peek().min < n) {
						return true;
					}
					stack.push(last);
				}
			}
			
		}
		return false;
	}
}
