package stack;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackWithQueue {
	Queue<Integer> Q;
    /** Initialize your data structure here. */
    public ImplementStackWithQueue() {
        this.Q = new LinkedList<>();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        Q.add(x);
        //rotate Q
        for (int i = 1; i < Q.size(); i++) {
            Q.add(Q.poll());
        }
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return Q.poll();
    }
    
    /** Get the top element. */
    public int top() {
        return Q.peek();
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return Q.isEmpty();
    }
}
