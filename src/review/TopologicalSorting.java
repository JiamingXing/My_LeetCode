package review;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class TopologicalSorting {
	public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
		ArrayList<DirectedGraphNode> res = new ArrayList<>();
		HashMap<DirectedGraphNode, Integer> inDegree = new HashMap<>();
		for (DirectedGraphNode node : graph) {
			for (DirectedGraphNode neighbor : node.neighbors) {
				inDegree.put(neighbor, inDegree.getOrDefault(neighbor, 0) + 1);
			}
		}
		Queue<DirectedGraphNode> Q = new LinkedList<>();
		for (DirectedGraphNode node : graph) {
			if (inDegree.get(node) == 0) {
				Q.offer(node);
			}
		}
		while (!Q.isEmpty()) {
			DirectedGraphNode node = Q.poll();
			res.add(node);
			for (DirectedGraphNode neighbor : node.neighbors) {
				inDegree.put(neighbor, inDegree.get(neighbor)-1);
				if (inDegree.get(neighbor) == 0) {
					res.add(neighbor);
					Q.offer(neighbor);
				}
			}
		}
		return res;
	}
}
