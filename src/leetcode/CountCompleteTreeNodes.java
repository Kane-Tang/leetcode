package leetcode;

import java.util.ArrayList;
import java.util.List;

public class CountCompleteTreeNodes {

	public CountCompleteTreeNodes() {
		// TODO Auto-generated constructor stub
	}

	private int level = 0;
	private int num = 0;
	public int countNodes(TreeNode root) {
		return root != null ? 1 + countNodes(root.right) + countNodes(root.left) : 0;
//		if(root == null) {
//			return 0;
//		}
//		//bfs
//		int res = 0;
//		List<TreeNode> list = new ArrayList();
//		list.add(root);
//		traverse(list);
//		for(int i=0;i<level-1;i++) {
//			res += Math.pow(2, i);
//		}
//		res += num;
//		return res;
	}
	
	public void traverse(List<TreeNode> list) {
		if(list.size() == 0) {
			return;
		}
		level++;
		List<TreeNode> newList = new ArrayList();
		for(TreeNode n: list) {
			if(n.left != null) {
				newList.add(n.left);
			}
			if(n.right != null) {
				newList.add(n.right);
			}
		}
		if(newList.size() == 0) {
			//last level
			num = list.size();
			return;
		}else {
			traverse(newList);
		}
	}
}
