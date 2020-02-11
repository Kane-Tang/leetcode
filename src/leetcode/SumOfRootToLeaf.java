package leetcode;

import java.util.ArrayList;
import java.util.List;

public class SumOfRootToLeaf {

	public SumOfRootToLeaf() {
		// TODO Auto-generated constructor stub
	}
	
	private List<String> list;
	public int sumRootToLeaf(TreeNode root) {
		//dfs
		if(root == null) {
			return 0;
		}
		list = new ArrayList();
		traverse(root, "");
		int ans = 0;
		for(int i=0;i<list.size();i++) {
			ans += Integer.parseInt(list.get(i),2);
		}
		// ans;
		return sumRootToLeaf(root, 0);
	}
	
	public int sumRootToLeaf(TreeNode root, int sum) {
		if (root == null)
			return 0;
		sum = (sum * 2) + root.val;
		if ((root.left == null) && (root.right == null))
			return sum;
		return sumRootToLeaf(root.left, sum) + sumRootToLeaf(root.right, sum);
	}
	
	public void traverse(TreeNode node, String path) {
		if(node == null) {
			return;
		}
		if(node.left==null && node.right==null) {
			path += Integer.toString(node.val);
			list.add(path);
			return;
		}
		path += Integer.toString(node.val);
		traverse(node.left, path);
		traverse(node.right, path);
	}
}
