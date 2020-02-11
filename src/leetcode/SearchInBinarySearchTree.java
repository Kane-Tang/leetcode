package leetcode;

public class SearchInBinarySearchTree {

	public SearchInBinarySearchTree() {
		// TODO Auto-generated constructor stub
	}
	public TreeNode searchBST(TreeNode root, int val) {
        return traverse(root, val);
    }
	
	public TreeNode traverse(TreeNode root, int val) {
		if(root == null) {
			return root;
		}
		if(root.val == val) {
			return root;
		}else if(root.val < val) {
			return traverse(root.right, val);
		}else {
			return traverse(root.left, val);
		}
	}
}
