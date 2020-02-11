package leetcode;

import java.util.ArrayList;
import java.util.List;

public class MaximumDepth {
	private int depth = 0;
	public int maxDepth(TreeNode root) {
		if(root==null) {
			return 0;
		}
		List<TreeNode> list = new ArrayList();
		list.add(root);
		//return findAns(list);
		findDepth(root, 1);
		return depth;
	}
	
	//bfs
	public int findAns(List<TreeNode> list) {
		if(list.isEmpty()) {
			return 0;
		}else {
			List<TreeNode> newList = new ArrayList();
			for(TreeNode node: list) {
				if(node.left!=null) {
					newList.add(node.left);
				}
				if(node.right!=null) {
					newList.add(node.right);
				}
			}
			if(newList.size()==0) {
				return 1;
			}else {
				return findAns(newList)+1;
			}
		}
	}
	
	//dfs
	public void findDepth(TreeNode root, int level) {
		if(root == null) {
			return ;
		}else {
			if(level>depth) {
				depth = level;
			}
			
			if(root.left!=null) {
				findDepth(root.left, level+1);
			}
			if(root.right!=null) {
				findDepth(root.right, level+1);
			}
		}
	}
}
