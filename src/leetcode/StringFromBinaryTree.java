package leetcode;

public class StringFromBinaryTree {

	public StringFromBinaryTree() {
		// TODO Auto-generated constructor stub
	}

	public String tree2str(TreeNode t) {
		StringBuilder s = new StringBuilder();
		helper(t, s);
		return s.toString();
	}
	
	public void helper(TreeNode node, StringBuilder s) {
		if(node == null) {
			return;
		}
		s.append(node.val);
		if(node.left != null) {
			s.append("(");
			helper(node.left, s);
			s.append(")");
		}else if(node.left==null && node.right!=null) {
			s.append("()");
		}
		
		if(node.right!=null) {
			s.append("(");
			helper(node.right, s);
			s.append(")");
		}
		if(node.left==null && node.right==null){
			return;
		}
	}
}
