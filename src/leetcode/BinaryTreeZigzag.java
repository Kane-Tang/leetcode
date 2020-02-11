package leetcode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeZigzag {
	
	private List<List<Integer>> list = new ArrayList();
	public BinaryTreeZigzag() {
		// TODO Auto-generated constructor stub
	}

	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		//bfs
		List<TreeNode> data = new ArrayList();
		if(root==null){
            return list;
        }
		data.add(root);
		traverse(data, 0);//0 means left to right
		return list;
	}
	
	public void traverse(List<TreeNode> data, int dir) {
		if(data.isEmpty()) {
			return;
		}
		List<Integer> cur = new ArrayList();
		List<TreeNode> newData = new ArrayList();
		for(TreeNode tmp: data) {
			if(tmp.left!=null) {
				newData.add(tmp.left);
			}
			if(tmp.right!=null) {
				newData.add(tmp.right);
			}
		}
		if(dir == 0) {
			//left to right
			for(int i=0;i<data.size();i++) {
				cur.add(data.get(i).val);
			}
			list.add(cur);
			traverse(newData, 1);
		}else {
			//right to left
			for(int i=data.size()-1;i>=0;i--) {
				cur.add(data.get(i).val);
			}
			list.add(cur);
			traverse(newData, 0);
		}
	}

}
