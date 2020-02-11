package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class MaxDepth {

	public MaxDepth() {
		// TODO Auto-generated constructor stub
	}

	public int maxDepth(Node root) {
		return depth(root);
	}
	
	public int depth(Node root) {
		if(root == null) {
			return 0;
		}else {
			List<Node> c = root.children;
			if(c.isEmpty()) {
				return 1;
			}
			List<Integer> heights = new LinkedList();
			for(Node n: c) {
				heights.add(depth(n));
			}
			return Collections.max(heights)+1;
		}
	}
}
