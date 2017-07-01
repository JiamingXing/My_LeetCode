package binaryTree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//Bottom-Up level order traversal
//因为list先输出的是最后一个level的节点值，所以可能用DFS实现BFS的方法来做
//如果用queue做BFS的话 必然先输出上层节点的值所以可能不行
//这里的一种方法需要用到自己不熟悉的linkedlist来实现
//如果用linkedlist这道题BFS DFS均可行
public class levelOrderTraversalBU {
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		// BFS
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		List<List<Integer>> result = new LinkedList<>();
		if(root == null){
			return result;
		}
		queue.offer(root);
		while(!queue.isEmpty()){
			int size = queue.size();
			List<Integer> temp = new LinkedList<>();
			for(int i = 0; i < size; i ++){
				if(queue.peek().left != null){
					queue.offer(queue.peek().left);
				}
				if(queue.peek().right != null){
					queue.offer(queue.peek().right);
				}
				temp.add(queue.poll().val);
			}
			result.add(0, temp);
		}
		return result;
	}
}

/*
 * DFS solution
public class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> wrapList = new LinkedList<List<Integer>>();
        levelMaker(wrapList, root, 0);
        return wrapList;
    }
    
    public void levelMaker(List<List<Integer>> list, TreeNode root, int level) {
        if(root == null) return;
        if(level >= list.size()) {
            list.add(0, new LinkedList<Integer>());
        }
        levelMaker(list, root.left, level+1);
        levelMaker(list, root.right, level+1);
        list.get(list.size()-level-1).add(root.val);
    }
}
*/
