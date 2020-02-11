package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class LowestCommonAncestorOfBST {

	public LowestCommonAncestorOfBST() {
		// TODO Auto-generated constructor stub
	}

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		while(root != null) {
			if(p.val > root.val && q.val > root.val) {
				root = root.right;
			}else if(p.val < root.val && q.val < root.val) {
				root = root.left;
			}else {
				return root;
			}
		}
		return null;
		
		
		
		
		//firstly, find parent
//		Deque<TreeNode> deque = new ArrayDeque();
//		HashMap<TreeNode, TreeNode> parent = new HashMap();
//		deque.add(root);
//		parent.put(root, null);
//		while(!parent.containsKey(p) || !parent.containsKey(q)) {
//			TreeNode node = deque.poll();
//			if(node.left != null) {
//				parent.put(node.left, node);
//				deque.add(node.left);
//			}
//			if(node.right != null) {
//				parent.put(node.right, node);
//				deque.add(node.right);
//			}
//		}
//		
//		Set<TreeNode> ancestor = new HashSet();
//		while(p!=null) {
//			ancestor.add(p);
//			p = parent.get(p);
//		}
//		
//		while(!ancestor.contains(q)) {
//			q = parent.get(q);
//		}
//		return q;
	}
}
