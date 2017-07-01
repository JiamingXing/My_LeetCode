package stack;
//这个方法也不是自己想到的。。体会一下
//其实一个stack的本质就是先进后出 但是为什么感觉很难想到
//比如这道题 知道用stack的情况下 让nums中的元素push到stack中然后
//进行一定的操作维持一个递增栈？？？？
//这道题的前提条件是findNums 数组是nums数组的子数组
//比如这道题的例子 findNums[4,1,2] nums[1,3,4,2]
//如果我需要用栈操作来实现 那么我每次都是要找next greater 
//所以后面的元素应该后进栈 思路可以转换成我 我将这个栈维持成一个递减栈 
//所以我一旦进来一个大的元素那么 我会把前面所有比这个元素小的元素都pop掉
//而pop掉的元素所对应的next greater 也就是我这个进来的大的元素
//那么接下来好好思考下 nextGreaterII里循环数组的区别在什么地方
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElementI {
	public int[] nextGreaterElement(int[] findNums, int[] nums) {
		Stack<Integer> stack = new Stack<>();
		Map<Integer, Integer> map = new HashMap<>();
		for (int n : nums) {
			while (!stack.isEmpty() && stack.peek() < n) {
				map.put(stack.pop(), n);
			}
			stack.push(n);
		}
		int[] result = new int[findNums.length];
		for (int i = 0; i < findNums.length; i++) {
			result[i] = map.getOrDefault(findNums[i], -1);
		}
		return result;
	}

}
