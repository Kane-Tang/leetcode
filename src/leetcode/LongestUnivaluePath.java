package leetcode;

public class LongestUnivaluePath {

	public LongestUnivaluePath() {
		// TODO Auto-generated constructor stub
	}

	int ans = 0;
	public int longestUnivaluePath(TreeNode root) {
		traverse(root);
		return ans;
	}
	
	public int traverse(TreeNode node) {
		if(node == null) {
			return 0;
		}
		int left = 0;
		int right = 0;
		if(node.left != null) {
			if(node.left.val == node.val){
				left += 1+traverse(node.left);
			}else{
				traverse(node.left);
			}
		}
			
		if(node.right != null) {
			if(node.right.val == node.val){
				right += 1+traverse(node.right);
			}else{
				traverse(node.right);
			}
		}
		if(left+right>ans) {
			ans = left+right;
		}
		return Math.max(left, right);
	}
}
