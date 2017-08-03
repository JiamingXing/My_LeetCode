package dfs;
//这道题到时候和copy linked list with random pointer一起复习deep copy
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

//这道题很像 copy linked list with random pointer 考察deep-copy
//关键在于 我copy出新节点之后 我们要确定新老节点的映射关系
//图上的BFS和树上的BFS本质区别是图上的BFS需要一个hash table来辅助进行BFS
//因为对于图来说连个节点连接是相互的 我如果在一个节点上访问到某个neighbor
//那么我到哪个neighbor的时候势必会访问到这个节点 出现重复
//所以我们需要一个hash table 来规避这种情况
//如果这道题一遍copy node 一遍copy对应的neighbors逻辑很容易混乱
public class CloneGraph {
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		if (node == null) {
			return null;
		}
		//1. copy nodes
		//2. copy edges
		//因为这道题只给你无向图中的一个node  所以肯定要先通过这个node知道整个图的结构
		//经典的BFS问题
		Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
//		Queue<UndirectedGraphNode> Q = new LinkedList<>();
		//这里用Queue不好 可能需要用ArrayList和一个指针来自己写一个队列
		//或者用两个Q 一个进队 一个出队？
		//因为我不希望它pull
		ArrayList<UndirectedGraphNode> Q = new ArrayList<>();
		//clone nodes
		Q.add(node);
		map.put(node, new UndirectedGraphNode(node.label));
		//定义开始指针 
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
		//clone neighbors
		for (int i = 0; i < Q.size(); i++) {
			UndirectedGraphNode newNode = map.get(Q.get(i));
			for (UndirectedGraphNode neighbor : Q.get(i).neighbors) {
				//newNode的neighbors包括Q.get(i).neighbors在map里对应的newNode
				newNode.neighbors.add(map.get(neighbor));
			}
		}
		return map.get(node);
	}
}
