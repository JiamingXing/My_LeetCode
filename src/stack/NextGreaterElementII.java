package stack;

import java.util.Stack;
//这个思路怎么形成的。。。
//这个思路很难想出来 需要经验积累
//关键在于问题变成了 循环数组 那么我们如何操作可以让栈也循环起来
public class NextGreaterElementII {
	public int[] nextGreaterElements(int[] nums) {
		int n = nums.length;
        int[] result = new int[n];
        
        Stack<Integer> stack = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            stack.push(i);
        }
        
        for (int i = n - 1; i >= 0; i--) {
            result[i] = -1;
            while (!stack.isEmpty() && nums[stack.peek()] <= nums[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()){
                result[i] = nums[stack.peek()];
            }
            stack.add(i);
        }
        
        return result;
	}

}
