package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class DistanceInBinaryTree {

	public DistanceInBinaryTree() {
		// TODO Auto-generated constructor stub
	}

	HashMap<TreeNode, TreeNode> parent = new HashMap();
	public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
		traverse(root);
		//bfs from target
		List<Integer> list = new ArrayList();
		Queue<TreeNode> queue = new LinkedList();
		queue.add(null);
		queue.add(target);
		
		Set<TreeNode> visit = new HashSet();
		visit.add(null);
		visit.add(target);
		int dist = 0;
		while(!queue.isEmpty()) {
			TreeNode node = queue.poll();
			if(node == null) {
				if(dist == K) {
					for(TreeNode n: queue) {
						list.add(n.val);
					}
					return list;
				}else {
					queue.add(null);
					dist++;
				}
			}else {
				//one more level
				if(!visit.contains(node.left)) {
					queue.add(node.left);
					visit.add(node.left);
				}
				if(!visit.contains(node.right)) {
					queue.add(node.right);
					visit.add(node.right);
				}
				if(!visit.contains(parent.get(node))) {
					queue.add(parent.get(node));
					visit.add(parent.get(node));
				}
			}
		}
		return list;
	}
	
	public void traverse(TreeNode node) {
		if(node == null) {
			return;
		}
		if(node.left!=null) {
			parent.put(node.left, node);
		}
		if(node.right!=null) {
			parent.put(node.right, node);
		}
		traverse(node.left);
		traverse(node.right);
	}
}
