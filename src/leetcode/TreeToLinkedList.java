package leetcode;

import java.util.LinkedList;

public class TreeToLinkedList {

	public TreeToLinkedList() {
		// TODO Auto-generated constructor stub
	}
	
	public TreeNode flattenTree(TreeNode node) {
		if(node == null) {
			return null;
		}
		
		if(node.left == null && node.right == null) {
			return node;
		}
		
		TreeNode left = flattenTree(node.left);
		TreeNode right  = flattenTree(node.right);
		
		if(left != null) {
			left.right = node.right;
			node.right = node.left;
			node.left = null;
		}
		
		if(right != null) {
			return right;
		}else {
			return left;
		}
	}

	public void flatten(TreeNode root) {
		this.flattenTree(root);
	}
}
