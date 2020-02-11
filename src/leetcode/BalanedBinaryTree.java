package leetcode;

import java.util.ArrayList;
import java.util.List;

public class BalanedBinaryTree {

	public BalanedBinaryTree() {
		// TODO Auto-generated constructor stub
	}

	private boolean res = true;
	public boolean isBalanced(TreeNode root) {
		traverse(root);
		return res;
	}
	
	public int traverse(TreeNode node) {
		if(node == null) {
			return 0;
		}
		int l = traverse(node.left);
		int r = traverse(node.right);
		if(Math.abs(l-r) > 1) {
			res = false;
		}
		return 1+Math.max(l, r);
	}
}
