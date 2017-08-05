package review;

import java.util.ArrayList;

public class DirectedGraphNode {
	int label;
	ArrayList<DirectedGraphNode> neighbors;
	DirectedGraphNode(int x) {
		this.label = x;
		this.neighbors = new ArrayList<DirectedGraphNode>();
	}
}
