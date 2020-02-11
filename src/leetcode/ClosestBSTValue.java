package leetcode;

public class ClosestBSTValue {

	public ClosestBSTValue() {
		// TODO Auto-generated constructor stub
	}

	double min = 0.0;
	int ans = 0;
	public int closestValue(TreeNode root, double target) {
		min = Math.abs(root.val-target);
		ans = root.val;
		traverse(root, target);
		return ans;
	}
	
	public void traverse(TreeNode node, double target) {
		if(node == null) {
			return;
		}
		if(Math.abs(node.val-target)<=min) {
			min = Math.abs(Math.abs(node.val-target));
			ans = node.val;
		}
		traverse(node.left, target);
		traverse(node.right, target);
	}
}
