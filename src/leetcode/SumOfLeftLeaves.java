package leetcode;

public class SumOfLeftLeaves {

	public SumOfLeftLeaves() {
		// TODO Auto-generated constructor stub
	}

	private int ans = 0;
	public int sumOfLeftLeaves(TreeNode root) {
		traverse(root);
		return ans;
	}
	
	public void traverse(TreeNode node) {
		if(node == null) {
			return;
		}
		if(node.left != null  && (node.left.left==null && node.left.right==null)) {
			ans += node.left.val;
		}
		traverse(node.left);
		traverse(node.right);
	}
}
