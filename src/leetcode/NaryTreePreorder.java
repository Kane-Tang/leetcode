package leetcode;

import java.util.ArrayList;
import java.util.List;

public class NaryTreePreorder {

	public NaryTreePreorder() {
		// TODO Auto-generated constructor stub
	}

	private List<Integer> list;
	public List<Integer> preorder(Node root) {
		list = new ArrayList();
		traverse(root);
		return list;
	}
	
	public void traverse(Node node) {
		if(node == null) {
			return;
		}
		list.add(node.val);
		for(Node n: node.children) {
			traverse(n);
		}
		
		//post order
		if(node == null) {
			return;
		};
		for(Node n: node.children) {
			traverse(n);
		}
		list.add(node.val);
	}
}
