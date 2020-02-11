package leetcode;

import java.util.ArrayList;
import java.util.HashMap;

public class CloseGraph { 

	private HashMap<Integer, Node> seen = new HashMap();
	public CloseGraph() {
		// TODO Auto-generated constructor stub
	}

	public Node cloneGraph(Node node) {
		int id = node.val;
		Node thisNode = null;
		if(!seen.containsKey(id)) {
			thisNode = new Node(id, new ArrayList());
			seen.put(id, thisNode);
			for(Node neighbour: node.neighbors) {
				int childId = neighbour.val;
				if(seen.containsKey(childId)) {
					Node newChild = seen.get(childId);
					thisNode.neighbors.add(newChild);
				}else {
					Node newChild = cloneGraph(neighbour);
					thisNode.neighbors.add(newChild);
				}
			}
		}
		return thisNode;
	}
}
