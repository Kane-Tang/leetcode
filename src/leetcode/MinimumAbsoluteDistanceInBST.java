package leetcode;

public class MinimumAbsoluteDistanceInBST {

	public MinimumAbsoluteDistanceInBST() {
		// TODO Auto-generated constructor stub
	}
	Integer prev;
	int minDiff = Integer.MAX_VALUE;

	public int getMinimumDifference(TreeNode root) {
		inorder(root);
		return minDiff;
	}

	private void inorder(TreeNode root) {
		if (root == null)
			return;
		inorder(root.left);
		if (prev != null)
			minDiff = Math.min(minDiff, Math.abs(root.val - prev));
		prev = root.val;
		inorder(root.right);
	}
}
