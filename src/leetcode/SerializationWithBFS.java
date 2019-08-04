package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class SerializationWithBFS {
	public String serialize(TreeNode root) {
		if (root == null)
			return "";
		StringBuffer sb = new StringBuffer();
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				TreeNode p = queue.poll();
				if (p != null) {
					sb.append(p.val).append(' ');
					queue.add(p.left);
					queue.add(p.right);
				} else
					sb.append("# ");
			}
		}
		return sb.substring(0, sb.length() - 1);
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		if (data.length() == 0)
			return null;
		String[] strs = data.split(" ");
		int i = 0, n = strs.length;
		Queue<TreeNode> queue = new LinkedList<>();
		TreeNode root = new TreeNode(Integer.parseInt(strs[i++]));
		queue.add(root);
		while (!queue.isEmpty() && i < n) {
			int size = queue.size();
			for (int j = 0; j < size; j++) {
				TreeNode p = queue.poll();
				if (i >= n)
					break;
				if (strs[i].equals("#")) {
					p.left = null;
				} else {
					p.left = new TreeNode(Integer.parseInt(strs[i]));
					queue.add(p.left);
				}
				if (++i >= n)
					break;
				if (strs[i].equals("#")) {
					p.right = null;
				} else {
					p.right = new TreeNode(Integer.parseInt(strs[i]));
					queue.add(p.right);
				}
				i++;
			}
		}
		return root;
	}
}
