package leetcode;

import java.util.ArrayList;
import java.util.List;

public class SymmetricTree {
	public boolean isSymmetric(TreeNode root) {
		//bfs method
		List<TreeNode> list = new ArrayList();//store the nodes in the current level
		if(root == null) {
			return true;
		}
		list.add(root);
		while(list.size()!=0) {
			List<TreeNode> tmp = new ArrayList();
			List<Integer> check = new ArrayList();
			for(int i=0;i<list.size();i++) {
				TreeNode node = list.get(i);
				if(node.left != null) {
					tmp.add(node.left);
					check.add(node.left.val);
				}
				if(node.left == null) {
					check.add(-1);
				}
				if(node.right != null) {
					tmp.add(node.right);
					check.add(node.right.val);
				}
				if(node.right == null) {
					check.add(-1);
				}
			}
			
			//check the current level
			for(int i=0;i<check.size();i++) {
				if(check.get(i)!=check.get(check.size()-1-i)) {
					return false;
				}
			}
			
			list.clear();
			if(tmp.size()!=0) {
				for (int i = 0; i < tmp.size(); i++) {
					list.add(tmp.get(i));
				}
			}
			
		}
		return true;
	}
}
