package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class InroderTraverse {

	public InroderTraverse() {
		// TODO Auto-generated constructor stub
	}

	public List<Integer> inorderTraversal(TreeNode root) {
		LinkedList<Integer> list = new LinkedList();
		//findAns(root, list);
		
		//follow up: iterate method
		//dfs
		Stack<TreeNode> stack = new Stack();
		TreeNode cur = root;
		while(!stack.isEmpty() || cur!=null) {
			while(cur!=null) {
				stack.push(cur);
				cur = cur.left;
			}
			cur = stack.pop();
			list.add(cur.val);
			cur = cur.right;
		}
		return list;
	}
	
	public void findAns(TreeNode node, LinkedList<Integer> list) {
		if(node == null) {
			return;
		}
		findAns(node.left, list);
		list.add(node.val);
		findAns(node.right, list);
	}
}
