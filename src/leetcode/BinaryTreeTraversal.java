package leetcode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeTraversal {
	public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList();
        List<TreeNode> parent = new ArrayList();
        if(root == null){
            return list;
        }
        parent.add(root);
        findAns(parent, list);// bfs, use a list to store the current nodes on the current level
        return list;
    }
	
	public void findAns(List<TreeNode> parent, List<List<Integer>> list) {
		List<Integer> data = new ArrayList();
		for(int i=0;i<parent.size();i++) {
			TreeNode node = parent.get(i);
			data.add(node.val);
		}
		list.add(data);
		List<TreeNode> children = new ArrayList();
		for(int i=0;i<parent.size();i++) {
			TreeNode node = parent.get(i);
			if(node.left != null) {
				children.add(node.left);
			}
			if(node.right != null) {
				children.add(node.right);
			}
		}
		if(children.size() != 0) {
			findAns(children, list);
		}
	}
}
