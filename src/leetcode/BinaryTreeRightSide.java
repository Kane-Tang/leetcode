package leetcode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeRightSide {
	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> ans = new ArrayList();
		if(root==null) {
			return ans;
		}
//		while(root != null) {
//			ans.add(root.val);
//			root = root.right;
//		}
		int level = 0;
		List<TreeNode> node = new ArrayList();
		node.add(root);
		getAns(node, ans, level);//search in BFS way
		return ans;
	} 
	
	public void getAns(List<TreeNode> node, List<Integer> ans, int level) {
		int size = node.size();
		if(size==0) {
			return;
		}
		ans.add(node.get(size-1).val);
		List<TreeNode> newNode = new ArrayList();
		for(int i=0;i<size;i++) {
			if(node.get(i).left != null) {
				newNode.add(node.get(i).left);
			}
			if(node.get(i).right != null) {
				newNode.add(node.get(i).right);
			}
		}
		if(newNode.size()==0) {
			return;
		}
		getAns(newNode,ans, level++);
	}
	
}
