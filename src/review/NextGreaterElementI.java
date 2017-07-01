package review;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
//第二遍做还是不容易想到 好好思考下如何利用stack先进后出的特性
public class NextGreaterElementI {
	public int[] nextGreaterElement(int[] findNums, int[] nums) {
		Stack<Integer> stack = new Stack<>();
		Map<Integer, Integer> map = new HashMap<>();
		for (int n : nums) {
			stack.push(n);
			//思路还是始终维持递减栈 如果要进来的元素比peek大 不断pop
			//被pop掉的元素的next greater 是要进来的元素
			while (!stack.isEmpty() && stack.peek() < n) {
				map.put(stack.pop(), n);
			}
			stack.push(n);
		}
		int[] result = new int[findNums.length];
		for (int i = 0; i < result.length; i++) {
			result[i] = map.getOrDefault(findNums[i], -1);
		}
		return result;
	}

}
