package binaryTree;

import java.util.ArrayList;
import java.util.List;

//脑子中形成了两条思路 BFS DFS
//BFS思路和level order traversal思路一样 只不过每一层加一个最大值而已
public class largestValueEachRow {
	public List<Integer> largestValues(TreeNode root) {
		List<Integer> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        ArrayList<TreeNode> Q = new ArrayList<>();
        Q.add(root);
        while(!Q.isEmpty()){
            int max = Integer.MIN_VALUE;
            int size = Q.size();
            for(int i = 0; i < size; i ++){
                TreeNode node = Q.get(0);
                max = Math.max(max, node.val);
                if(node.left != null){
                    Q.add(node.left);
                }
                if(node.right != null){
                    Q.add(node.right);
                }
                Q.remove(0);
            }
            result.add(max);
        }
        return result;
	}
}
// DFS

