package leetcode;

import java.util.ArrayList;
import java.util.List;

public class MaxPathSum {
	int max = Integer.MIN_VALUE;
	public int maxPathSum(TreeNode root) {
		if(root == null) {
			return 0;
		}
		
		//use dfs
		List<TreeNode> list = new ArrayList();
		List<TreeNode> leaves = new ArrayList();
		//findLeaves(list, leaves);
		findPath(root);
		return max;
	}
	
	public int findPath(TreeNode root) {
		if(root == null) {
			return 0;
		}else {
			int leftPart = Math.max(0, findPath(root.left));
			int rightPart = Math.max(0, findPath(root.right));
			int tmp = root.val+leftPart+rightPart;
			// update max_sum if it's better to start a new path
			max = Math.max(max, tmp);
			
			// return the max gain if continue the same path
			return root.val+Math.max(leftPart, rightPart);
		}
	}
	
	public void findLeaves(List<TreeNode> list, List<TreeNode> leaves) {
		if(list.isEmpty()) {
			return;
		}
		List<TreeNode> newList = new ArrayList();
		for(TreeNode node: list) {
			if(node.left!=null) {
				newList.add(node.left);
			}
			if(node.right!=null) {
				newList.add(node.right);
			}
			if(node.left==null && node.right==null) {
				leaves.add(node);
			}
		}
		findLeaves(newList, leaves);
	}
}
