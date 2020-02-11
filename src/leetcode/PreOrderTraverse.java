package leetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class PreOrderTraverse {

	public PreOrderTraverse() {
		// TODO Auto-generated constructor stub
	}

	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList();
		//findAns(root, list);
		//iterative
		if(root == null) {
			return list;
		}
		//dfs
		Stack<TreeNode> stack = new Stack();
		stack.add(root);
		while(!stack.isEmpty()) {
			TreeNode node = stack.pop();
			list.add(node.val);
			if(node.right != null) {
				stack.add(node.right);
			}
			if(node.left != null) {
				stack.add(node.left);
			}
		}
		return list;
	} 
	
//	public void findAns(TreeNode root, List<Integer> list) {
//		if(root == null) {
//			return;
//		}
//		list.add(root.val);
//		findAns(root.left, list);
//		findAns(root.right, list);
//	}
}
