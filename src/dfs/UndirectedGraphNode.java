package dfs;

import java.util.ArrayList;
import java.util.List;

public class UndirectedGraphNode {
	int label;
	List<UndirectedGraphNode> neighbors;
	UndirectedGraphNode(int x) {
		this.label = x;
		this.neighbors = new ArrayList<UndirectedGraphNode>();
	}
}
