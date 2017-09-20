package review;

import java.util.Stack;

//要求O(1)时间复杂度以及O(h)空间复杂度
public class BSTIterator {
	Stack<TreeNode> stack = new Stack<>();
    public BSTIterator(TreeNode root) {
        TreeNode cur = root;
        while (cur != null) {
            stack.push(cur);
            cur = cur.left;
        }
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }
    
    /** @return the next smallest number */
    public int next() {
        TreeNode node = stack.pop();
        TreeNode cur = node;
        while (cur.right != null) {
            cur = cur.right;
            while (cur != null) {
            	stack.push(cur);
            	cur = cur.left;
            }
        }
        return node.val;
    }
}




//一开始自己写的从大到小进栈 但是空间复杂度不符合要求？
/*
public class BSTIterator {
    Stack<TreeNode> stack = new Stack<>();
    public BSTIterator(TreeNode root) {
        helper(root);
    }
    
    private void helper(TreeNode root) {
        if (root == null) {
            return;
        }
        helper(root.right);
        stack.push(root);
        helper(root.left);
    }
	
    /** @return whether we have a next smallest number
    public boolean hasNext() {
        return stack.isEmpty();
    }

    /** @return the next smallest number
    public int next() {
        if (!stack.isEmpty()) {
            return stack.pop().val;
        }
    }
}
*/
