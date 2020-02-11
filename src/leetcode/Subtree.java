package leetcode;

public class Subtree {

	public Subtree() {
		// TODO Auto-generated constructor stub
	}

	public boolean isSubtree(TreeNode s, TreeNode t) {
		return s!=null && (findAns(s,t) || isSubtree(s.left, t) || isSubtree(s.right, t));
	}
	
	public boolean findAns(TreeNode s, TreeNode t) {
		if(s == null && t == null) {
			return true;
		}
		if(s == null || t == null) {
			return false;
		}
		if(s.val == t.val) {
			return findAns(s.left, t.left) && findAns(s.right, t.right);
		}else {
			return false;
		}
	}
}
