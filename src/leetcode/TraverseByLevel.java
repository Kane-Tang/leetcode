package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TraverseByLevel {

	public TraverseByLevel() {
		// TODO Auto-generated constructor stub
	}

	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		LinkedList<List<Integer>> list = new LinkedList();
		List<TreeNode> level = new ArrayList();
		List<List<Integer>> res = new ArrayList();
		if(root == null) {
			return res;
		}
		level.add(root);
		findAns(level, list);
		
		for(int i=0;i<list.size();i++) {
			res.add(list.get(i));
		}
		return list;
	}
	
	public void findAns(List<TreeNode> level, LinkedList<List<Integer>> list) {
		if(level.size()==0) {
			return;
		}
		List<Integer> ans = new ArrayList();
		for(TreeNode node: level) {
			ans.add(node.val);
		}
		List<TreeNode> newLevel = new ArrayList();
		for(TreeNode node: level) {
			if(node.left != null) {
				newLevel.add(node.left);
			}
			if(node.right != null) {
				newLevel.add(node.right);
			}
		}
		list.addFirst(ans);
		findAns(newLevel, list);
	}
}
