package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

public class CopyList {
	HashMap<Node, Node> visit = new HashMap();
	/*
	public Node copyRandomList(Node head) {
		if(head == null) {
			return null;
		}
		if(this.visit.containsKey(head)) {
			return this.visit.get(head);
		}else {
			Node node = new Node(head.val, null, null);
			this.visit.put(head, node);
			node.next = copyRandomList(head.next);
			node.random = copyRandomList(head.random);
			return node;
		}	
	}
	*/
}
