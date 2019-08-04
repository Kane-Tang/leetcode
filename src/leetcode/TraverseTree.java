package leetcode;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class TraverseTree {
	private HashMap<Integer, TreeNode> build = new HashMap();

	public TreeNode buildTree(int[][] array) {
		int l = array.length;
		// find the root and its child nodes
		LinkedHashMap<Integer, TreeNode> current = new LinkedHashMap();
		TreeNode root = new TreeNode(1);
		build.put(1, root);
		current.put(1, root);
		List<Integer> visited = new ArrayList();
		for (int j = 0; j < l; j++) {
			HashMap<Integer, TreeNode> next = new HashMap();
			for (int i = 0; i < l; i++) {
				if (!visited.contains(i)) {
					if (current.containsKey(array[i][0])) {
						visited.add(i);
						TreeNode r = findNode(array[i][0]);
						TreeNode c = findNode(array[i][1]);
						if (r.left == null) {
							r.left = c;
							next.put(array[i][1], c);
						} else if (r.right == null) {
							r.right = c;
							next.put(array[i][1], c);
						} else {
							continue;
						}
					} else if (current.containsKey(array[i][1])) {
						visited.add(i);
						TreeNode r = findNode(array[i][1]);
						TreeNode c = findNode(array[i][0]);
						if (r.left == null) {
							r.left = c;
							next.put(array[i][0], c);
						} else if (r.right == null) {
							r.right = c;
							next.put(array[i][0], c);
						} else {
							continue;
						}
					}
				}

			}
			current.clear();
			Iterator<Entry<Integer, TreeNode>> iterator = next.entrySet().iterator();
			while (iterator.hasNext()) {
				Entry<Integer, TreeNode> entry = iterator.next();
				current.put(entry.getKey(), entry.getValue());
			}
		}
		return root;
	}

	public TreeNode findNode(int n) {
		if (build.containsKey(n)) {
			return build.get(n);
		} else {
			TreeNode tn = new TreeNode(n);
			build.put(n, tn);
			return tn;
		}
	}

	public int findTime(int[][] array) {
		TreeNode root = buildTree(array);
		List<TreeNode> l1 = new ArrayList();
		l1.add(root.left);
		List<TreeNode> l2 = new ArrayList();
		l2.add(root.right);
		return Math.max(getAns(l1), getAns(l2));
	}
	
	//bfs search
	public int getAns(List<TreeNode> list) {
		int size = list.size();
		if(size==0) {
			return 0;
		}
		int count = 0;
		List<TreeNode> newList = new ArrayList();
		for(int i=0;i<size;i++) {
			if(list.get(i).left!=null) {
				newList.add(list.get(i).left);
			}
			if(list.get(i).right!=null) {
				newList.add(list.get(i).right);
			}
		}
		return size+getAns(newList);
	}

	public static void main(String[] args) {
		int[][] array = new int[][] { { 1, 2 }, { 2, 3 }, { 4, 1 }, { 5, 2 }, { 6, 5 } };
		TraverseTree tt = new TraverseTree();
		int ans = tt.findTime(array);
		System.out.println(ans);
		
	}
}
