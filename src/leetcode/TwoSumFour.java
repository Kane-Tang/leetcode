package leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class TwoSumFour {

	public TwoSumFour() {
		// TODO Auto-generated constructor stub
	}

	public boolean findTarget(TreeNode root, int k) {
		return helper(root, k);
	}
	
	//find two elements
	public boolean helper(TreeNode node, int k) {
		Set<Integer> set = new HashSet();
		Queue<TreeNode> queue = new LinkedList();
		queue.add(node);
		while(!queue.isEmpty()) {
			if(queue.peek() != null) {
				TreeNode tmp = queue.poll();
				if(set.contains(k-tmp.val)) {
					return true;
				}
				set.add(tmp.val);
				queue.add(tmp.left);
				queue.add(tmp.right);
			}else {
				queue.poll();
			}			
		}
		return false;
	}
}
