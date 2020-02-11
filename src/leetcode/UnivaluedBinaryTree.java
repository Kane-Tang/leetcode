package leetcode;

public class UnivaluedBinaryTree {

	public UnivaluedBinaryTree() {
		// TODO Auto-generated constructor stub
	}
	private int num = 0;
	public boolean isUnivalTree(TreeNode root) {
		if(root == null) {
			return true;
		}
		num = root.val;
		return traverse(root);
	}
	
	public boolean traverse(TreeNode node) {
		if(node == null) {
			return true;
		}
		if(node.val == num) {
			return traverse(node.left) && traverse(node.right);
		}else {
			return false;
		}
	}
}
