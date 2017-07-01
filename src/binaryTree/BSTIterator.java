package binaryTree;
//本质是用stack做tree的中序遍历
import java.util.Stack;

//这道题摸不到头脑说明不会java
//看不懂这个道题让你写什么
public class BSTIterator {
	private Stack<TreeNode> stack = new Stack<>();
	public BSTIterator(TreeNode root) {
		TreeNode cur = root;
		while(cur != null) {
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
    	if(cur.right != null) {
    		cur = cur.right;
    		while(cur != null) {
    			stack.push(cur);
    			cur = cur.left;
    		}
    	}
    	return node.val;
    }

}
