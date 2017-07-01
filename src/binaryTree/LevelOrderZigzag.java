package binaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderZigzag {
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		if (root == null) {
			return result;
		}
		//虽然这道题思路没问题 但是tag = 0的时候还是1的时候 左到右
		//编译错误了。。 还是不够自信啊
		int tag = 0;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			List<Integer> temp = new LinkedList<>();
			for (int i = 0; i < size; i++) {
				if (queue.peek().right != null) {
					queue.offer(queue.peek().right);
				}
				if (queue.peek().left != null) {
					queue.offer(queue.peek().left);
				}
				if (tag == 1) {
					temp.add(queue.poll().val);
				}
				if (tag == 0) {
					temp.add(0, queue.poll().val);
				}
			}
			result.add(temp);
			if (tag == 1) {
				tag = 0;
			} else if (tag == 0) {
				tag = 1;
			}
		}
		return result;
	}
}


//iterative的方法 速度更快一点 学习一下
/*
public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> sol = new ArrayList<>();
        travel(root, sol, 0);
        return sol;
    }
    private void travel(TreeNode curr, List<List<Integer>> sol, int level) {
        if(curr == null) return;
        
        if(sol.size() <= level)
        {
            List<Integer> newLevel = new LinkedList<>();
            sol.add(newLevel);
        }
        
        List<Integer> collection  = sol.get(level);
        if(level % 2 == 0) collection.add(curr.val);
        else collection.add(0, curr.val);
        
        travel(curr.left, sol, level + 1);
        travel(curr.right, sol, level + 1);
    }
}
*/
