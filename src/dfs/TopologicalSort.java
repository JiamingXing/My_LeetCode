package dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
//分别用BFS和DFS两种方法完成拓扑搜索
//算法总体思路计算每个点的inDegree 先把inDegree为0的点加到队列中
//然后依次遍历他们的neighbor，遍历到的node inDegree减一，如果减到0就加入到结果中
//BFS本质和Queue相关，DFS本质和stack相关
public class TopologicalSort {
	ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
		//BFS
		//inDegree / outDegree入度和出度
		ArrayList<DirectedGraphNode> res = new ArrayList<>();
		//一般在做图的题目的时候都要用到hashmap
		Map<DirectedGraphNode, Integer> map = new HashMap<>();
		for (DirectedGraphNode node : graph) {
			for (DirectedGraphNode neighbor : node.neighbors) {
				//统计入度
//				map.put(neighbor, map.getOrDefault(neighbor, 0)+1);
				if (map.containsKey(neighbor)) {
					map.put(neighbor, map.get(neighbor)+1);
				} else {
					map.put(neighbor, 1);
				}
			}
		}
		Queue<DirectedGraphNode> Q = new LinkedList<>();
		for (DirectedGraphNode node : graph) {
			//入度为0的点先加入到队列中
			if (!map.containsKey(node)) {
				Q.offer(node);
				res.add(node);
			}
		}
		while (!Q.isEmpty()) {
			DirectedGraphNode node = Q.poll();
			for (DirectedGraphNode temp : node.neighbors) {
				map.put(temp, map.get(temp) - 1);
				if (map.get(temp) == 0) {
					res.add(temp);
					Q.offer(temp);
				}
			}
		}
		return res;
		//最后输出的结果如果不包含原来graph里的所有点 那么这个有向图有环存在
		//if (res.size() != graph.size()) {return loop};
	}
}
