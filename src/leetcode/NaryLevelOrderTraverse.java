package leetcode;

import java.util.ArrayList;
import java.util.List;

public class NaryLevelOrderTraverse {

	public NaryLevelOrderTraverse() {
		// TODO Auto-generated constructor stub
	}
	
	private List<List<Integer>> res;
	public List<List<Integer>> levelOrder(Node root) {
		res = new ArrayList();
		if(root == null) {
			return res;
		}
		List<Node> list = new ArrayList();
		list.add(root);
		bfsTraverse(list);
		return res;
	}
	
	public void bfsTraverse(List<Node> list) {
		if(list.size()==0) {
			return;
		}
		List<Integer> cl = new ArrayList();
		for(Node n: list) {
			if(n!=null)
				cl.add(n.val);
		}
		res.add(cl);
		List<Node> newList = new ArrayList();
		for(Node n: list) {
			if(n==null) {
				continue;
			}
			List<Node> children = n.children;
			for(Node c: children) {
				newList.add(c);
			}
		}
		bfsTraverse(newList);
	}
}
