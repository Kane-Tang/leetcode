package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class PostOrderTraverse {

	public PostOrderTraverse() {
		// TODO Auto-generated constructor stub
	}

	public List<Integer> postorderTraversal(TreeNode root) {
		LinkedList<Integer> list = new LinkedList();
		if(root == null) {
			return list;
		}
		Stack<TreeNode> stack = new Stack();
		stack.add(root);
		while(!stack.isEmpty()) {
			TreeNode node = stack.pop();
			if(node.left != null) {
				stack.add(node.left);
			}
			if(node.right != null) {
				stack.add(node.right);
			}
			list.addFirst(node.val);
		}
		return list;
	}
}
