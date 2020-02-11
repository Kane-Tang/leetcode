package leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeafSimilarTree {

	public LeafSimilarTree() {
		// TODO Auto-generated constructor stub
	}

	public boolean leafSimilar(TreeNode root1, TreeNode root2) {
		List<Integer> l1 = new ArrayList();
		findLeaves(root1, l1);
		List<Integer> l2 = new ArrayList();
		findLeaves(root2, l2);
		if(l1.equals(l2)) {
			return true;
		}
		return false;
	}
	
	public void findLeaves(TreeNode root, List<Integer> leaves){
		if(root == null) {
			return;
		}
		if(root.left==null && root.right==null) {
			leaves.add(root.val);
		}
		findLeaves(root.left, leaves);
		findLeaves(root.right, leaves);
	}
}
