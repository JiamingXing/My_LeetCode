package binaryTree;

import java.util.ArrayList;
import java.util.List;

//我们发现BFS是非递归的 用队列用循环解决 而DFS需要递归解决

// BFS in binary tree
//queue  Use two queues or 1 queue + dummy node(哨兵节点)
//学会什么是queue 还有BFS的思路是怎样的 怎样分层！

//version 1: use one queue
public class levelOrderTraversal {
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        //本质是使用Queue 但是Arraylist也可以构造类似queue
        ArrayList<TreeNode> Q = new ArrayList<>();
        Q.add(root);
        while(!Q.isEmpty()){
            List<Integer> temp = new ArrayList<>();
            int size = Q.size();
            for(int i = 0; i < size; i ++){
                TreeNode node = Q.get(0);
                if(node.left != null){
                    Q.add(node.left);
                }
                if(node.right != null){
                    Q.add(node.right);
                }
                Q.remove(0);
                temp.add(node.val);
            }
            result.add(temp);
        }
        return result;
	}
}

// version 2: 2 queeus   -> time limit exceeded;
/*
public class levelOrderTraversal {
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		if(root == null){
			return result;
		}
		ArrayList<TreeNode> Q1 = new ArrayList<>();
		ArrayList<TreeNode> Q2 = new ArrayList<>();
		Q1.add(root);
		while(Q1.size() != 0){
			ArrayList<Integer> temp = new ArrayList<>();
			Q2.clear();
			for(int i = 0; i < Q1.size(); i ++){
				TreeNode node = Q1.get(i);
				temp.add(node.val);
				if(node.left != null){
					Q2.add(node.left);
				}
				if(node.right != null){
					Q2.add(node.right);
				}
			}
			swap(Q1, Q2);
			result.add(temp);
			
			
		}
		return result;
	}
	public void swap(ArrayList<TreeNode> Q1, ArrayList<TreeNode> Q2){
		ArrayList<TreeNode> temp = new ArrayList<>();
		temp = Q1;
		Q1 = Q2;
		Q2 = temp;
	}

}
*/



//version 2: 1 queue + dummy node
/*
public class Solution {
//   
//    @param root: The root of binary tree.
//    @return: Level order a list of lists of integer
//     
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (root == null) {
            return result;
        }
        
        Queue<TreeNode> Q = new LinkedList<TreeNode>();
        Q.offer(root);
        Q.offer(null); // dummy node
        
        ArrayList<Integer> level = new ArrayList<Integer>();
        while (!Q.isEmpty()) {
            TreeNode node = Q.poll();
            if (node == null) {
                if (level.size() == 0) {
                    break;
                }
                result.add(level);
                level = new ArrayList<Integer>();
                Q.offer(null); // add a new dummy node
                continue;
            }
            
            level.add(node.val);
            if (node.left != null) {
                Q.offer(node.left);
            }
            if (node.right != null) {
                Q.offer(node.right);
            }
        }
        
        return result;
    }
}
*/


// version 4: BFS By DFS
//时间复杂度很高 节省空间
//相当于一个时间换空间的算法

/*
public ArrayList<ArrayList<Integer>> levelOrder(TreeNode){
	ArrayList<ArrayList<Integer>> result = new ArrayList<>();
	if(root == null){
		return result;
	}
	int maxLevel = 0;
	while(true){
		ArrayList<Integer> level = new ArrayList<>();
		dfs(root, level, 0, maxLevel);
		if(level.size() == 0){
			break;
		}
		resul.add(level);
		maxLevel ++;
	}
	return result;
}

private void dfs(TreeNode root, ArrayList<Integer> level, int curtLevel, int maxLevel){
	if(root == null || curtLevel > maxLevel){
		return;
	}
	if(curtLevel == maxLevel){
		level.add(root.val);
		return;
	}
	dfs(root.left, level, curtLevel + 1, maxLevel);
	dfs(root.right, level, curtLevel + 1, maxLevel);
}

*/
