package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class IncreasingOrderSearchTree {

	public IncreasingOrderSearchTree() {
		// TODO Auto-generated constructor stub
	}
	
	private List<Integer> num = new ArrayList();
	public TreeNode increasingBST(TreeNode root) {
		if(root == null) {
			return null;
		}
		traverse(root);
		TreeNode node = new TreeNode(0);
		TreeNode n = node;
		for(int i=0;i<num.size();i++) {
			TreeNode c = new TreeNode(num.get(i));
			n.right = c;
			n = n.right;
		}
		return node.right;
	}
	
	public void traverse(TreeNode node) {
		if(node == null) {
			return;
		}
		traverse(node.left);
		num.add(node.val);
		traverse(node.right);
	}
}
