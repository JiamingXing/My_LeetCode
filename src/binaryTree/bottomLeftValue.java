package binaryTree;

//对于level-order-traversal的BFS的方法已经很熟悉了
//好好想一想什么样的题可以想到用BFS做 比如这道题当时怎么想到用BFS做的
import java.util.ArrayList;

public class bottomLeftValue {
	public int findBottomLeftValue(TreeNode root) {
		 ArrayList<TreeNode> Q = new ArrayList<>();
	        Q.add(root);
	        int result = 0;
	        while(!Q.isEmpty()){
	            int size = Q.size();
	            for(int i = 0; i < size; i ++){
	                TreeNode node = Q.get(0);
	                if(i == 0){
	                    result = node.val;
	                }
	                if(node.left != null){
	                    Q.add(node.left);
	                }
	                if(node.right != null){
	                    Q.add(node.right);
	                }
	                Q.remove(0);
	            }
	        }
	        return result;
	}

}
// ans h are global variables
/*
public class Solution {
    int ans=0, h=0;
    public int findBottomLeftValue(TreeNode root) {
        findBottomLeftValue(root, 1);
        return ans;
    }
    public void findBottomLeftValue(TreeNode root, int depth) {
        if (h<depth) {ans=root.val;h=depth;}
        if (root.left!=null) findBottomLeftValue(root.left, depth+1);
        if (root.right!=null) findBottomLeftValue(root.right, depth+1);
    }
}
*/



/*
public class Solution {
    public int findBottomLeftValue(TreeNode root) {
        return findBottomLeftValue(root, 1, new int[]{0,0});
    }
    public int findBottomLeftValue(TreeNode root, int depth, int[] res) {
        if (res[1]<depth) {res[0]=root.val;res[1]=depth;}
        if (root.left!=null) findBottomLeftValue(root.left, depth+1, res);
        if (root.right!=null) findBottomLeftValue(root.right, depth+1, res);
        return res[0];
    }
}
*/
