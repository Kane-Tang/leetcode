package leetcode;

public class BinarySearchTree {
	public boolean isValidBST(TreeNode root) {
		if(root == null) {
			return true;
		}
		return findAns(root, null, null);
	}
	
	public boolean findAns(TreeNode root, Integer low, Integer high) {
		if(root == null) {
			return true;
		}
		int val = root.val;
		if(low!=null && val<=low) {
			return false;
		}
		if(high!=null && val>=high) {
			return false;
		}
		
		if(!findAns(root.left, low, val)) {
			return false;
		}
		if(!findAns(root.right, val, high)) {
			return false;
		}
		return true;
	}
}
