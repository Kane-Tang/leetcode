package leetcode;

public class BinaryTreeTilt {

	public BinaryTreeTilt() {
		// TODO Auto-generated constructor stub
	}

	private int ans = 0;
	public int findTilt(TreeNode root) {
		if(root == null) {
			return 0;
		}
		traverse(root);
		return ans;
	}
	
	public void traverse(TreeNode node) {
		if(node == null) {
			return;
		}
		ans += Math.abs(tilt(node.left)-tilt(node.right));
		traverse(node.left);
		traverse(node.right);
	}
	
	public int tilt(TreeNode node) {
		if(node == null) {
			return 0;
		}
		return tilt(node.left)+tilt(node.right)+node.val;
	}
}
