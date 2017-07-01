package stack;

import java.util.Stack;

//很难想到用stack来解决的问题
//找每个树往左往右第一个比它小的数的位置
//如何在一个for循环中找
//特征就是从某个数开始往左往右 这种情况可以用递增栈或者递减栈来做
//自己再好好思考这道题的思路怎么形成的怎么写的这个程序 思路写法都很有技巧
//如果我pop某个height的值 计算的就是以这个height为minheight的最大矩形面积
public class LargestRectangHistofram {
	public int largestRectangleArea(int[] heights) {
		if (heights == null || heights.length == 0) {
			return 0;
		}
		Stack<Integer> stack = new Stack<>();
		int result = 0;
		for (int i = 0; i <= heights.length; i++) {
			int current = (i == heights.length) ? -1 : heights[i];
			while (!stack.isEmpty() && current <= heights[stack.peek()]) {
				int h = heights[stack.pop()];
				int w = stack.isEmpty() ? i : i - stack.peek() - 1;
				result = Math.max(result, w * h);
			}
			stack.push(i);
		}
		return result;
	}

}
