package leetcode;

public class DiameterOfBianryTree {
	int ans;
	public int diameterOfBinaryTree(TreeNode root) {
		if(root == null) {
			return 0;
		}
		if(root.left == null && root.right == null) {
			return 0;
		}
		findAns(root);
		return ans;
	}
	
	public int findAns(TreeNode root) {
		//dfs
		if(root == null) {
			return 0;
		}
		if(root.left == null && root.right == null) {
			return 1;
		}
		int l = 0;
		int r = 0;
		if(root.left != null) {
			l = findAns(root.left) + 1;
		}
		if(root.right != null) {
			r = findAns(root.right) + 1;
		}
		ans = Math.max(ans, l+r+1);
		return Math.max(l, r);
	}
}
