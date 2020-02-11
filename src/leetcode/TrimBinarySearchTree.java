package leetcode;

public class TrimBinarySearchTree {

	public TrimBinarySearchTree() {
		// TODO Auto-generated constructor stub
	}
	public TreeNode trimBST(TreeNode root, int L, int R) {
        return buildTree(root, L, R);
    }
	
	public TreeNode buildTree(TreeNode node, int l , int r) {
		if(node == null) {
			return null;
		}
		if(node.val>=l && node.val <=r) {
			node.left = buildTree(node.left, l, r);
			node.right = buildTree(node.right, l, r);
			return node;
		}else if(node.val > r){
			return buildTree(node.left, l, r);
		}else {
			return buildTree(node.right, l, r);
		} 
	}
}
