package review;

import java.util.Stack;
//第二遍做换了一种思路反而错了。。？还检查不出来哪里错了
public class MinStack {
	Stack<Integer> stack;
	Stack<Integer> minStack;
	/** initialize your data structure here. */
    public MinStack() {
        this.stack = new Stack<>();
        this.minStack = new Stack<>();
    }
    
    public void push(int x) {
        stack.push(x);
        if (minStack.isEmpty()) {
        	minStack.push(x);
        } else if (x <= minStack.peek()) {
        	minStack.push(x);
        }
    }
    
    public void pop() {
    	//这里不能用 == 要用equals 来判断是否相等
    	//class类的比较都用equals进行比较 
    	//除非是primitive type的数据
        if (stack.pop() == minStack.peek()) {
        	minStack.pop();
        }
        stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}
