package leetcode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePath {

	public BinaryTreePath() {
		// TODO Auto-generated constructor stub
	}

	List<String> list = new ArrayList();
	public List<String> binaryTreePaths(TreeNode root) {
		if(root == null) {
			return list;
		}
		helper(root,"");
		return list;
	}
	
	public void helper(TreeNode node, String path) {
		if(node == null) {
			list.add(path);
			return;
		}
		path += node.val;
		if(node.left != null) {
			path += "->";
			helper(node.left, path);
		}
		if(node.right != null) {
			if(node.left==null)
				path += "->";
			helper(node.right, path);
		}
		if(node.left == null && node.right == null) {
			list.add(path);
			return;
		}
	}
}
