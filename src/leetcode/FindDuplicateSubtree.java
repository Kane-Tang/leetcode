package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindDuplicateSubtree {
	public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
		List<TreeNode> list = new ArrayList();
		//dfs
		HashMap<String, Integer> hm = new HashMap();
		findAns(root, hm, list);
		return list;
	}
	
	public String findAns(TreeNode root, HashMap<String, Integer> hm, List<TreeNode> list) {
		if(root == null) {
			return "x";
		}
		
		String ans = root.val + findAns(root.left, hm, list) + findAns(root.right, hm, list);
		hm.put(ans, hm.getOrDefault(ans, 0)+1);
		if(hm.get(ans)==2) {
			list.add(root);
		}
		return ans;
	}
}
