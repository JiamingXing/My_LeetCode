package review;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class CloneGraph {
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		if (node == null) {
			return null;
		}
		Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
		Queue<UndirectedGraphNode> Q = new LinkedList<>();
		Queue<UndirectedGraphNode> inQ = new LinkedList<>();
		Q.offer(node);
		map.put(node, new UndirectedGraphNode(node.label));
		while (!Q.isEmpty()) {
			UndirectedGraphNode cur = Q.poll();
			inQ.offer(cur);
			for (UndirectedGraphNode temp : cur.neighbors) {
				if (!map.containsKey(temp)) {
					map.put(temp, new UndirectedGraphNode(temp.label));
					Q.offer(temp);
				}
			}
		}
		while (!inQ.isEmpty()) {
			UndirectedGraphNode cur = inQ.poll();
			for (UndirectedGraphNode neighbor : cur.neighbors) {
				map.get(cur).neighbors.add(map.get(neighbor));
			}
		}
		return map.get(node);
	}
}

//用ArrayList
/*
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
			return null;
		}
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
		ArrayList<UndirectedGraphNode> Q = new ArrayList<>();
		Q.add(node);
		map.put(node, new UndirectedGraphNode(node.label));
		int start = 0; 
		while (start < Q.size()) {
			UndirectedGraphNode cur = Q.get(start++);
			for (UndirectedGraphNode neighbor : cur.neighbors) {
				if (!map.containsKey(neighbor)) {
					map.put(neighbor, new UndirectedGraphNode(neighbor.label));
					Q.add(neighbor);
				}
			}
		}
		for (int i = 0; i < Q.size(); i++) {
			UndirectedGraphNode newNode = map.get(Q.get(i));
			for (UndirectedGraphNode neighbor : Q.get(i).neighbors) {
				newNode.neighbors.add(map.get(neighbor));
			}
		}
		return map.get(node);
    }
}
*/