package leetcode;

public class InvertTree {
	public TreeNode invertTree(TreeNode root) {
		if(root == null) {
			return null;
		}
		inverse(root);
		return root;
	}
	
	public void inverse(TreeNode node) {
		if(node == null) {
			return;
		}
		TreeNode tmp = node.left;
		node.left = node.right;
		node.right = tmp;
		inverse(node.left);
		inverse(node.right);
	}
}
