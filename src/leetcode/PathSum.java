package leetcode;

import java.util.ArrayList;
import java.util.List;

public class PathSum {
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> list = new ArrayList();
		if(root==null) {
			return list;
		}
		List<Integer> ans = new ArrayList();
		findPath(list, ans, root, sum);
		return list;
	}
	
	public void findPath(List<List<Integer>> list, List<Integer> ans, TreeNode root, int sum) {
		sum = sum-root.val;
		ans.add(root.val);
		if(sum==0 && root.left == null && root.right == null) {
			List<Integer> tmp = new ArrayList();
			for(int i=0;i<ans.size();i++) {
				tmp.add(ans.get(i));
			}
			list.add(tmp);
			ans.remove(ans.size()-1);
			return;
		}
		else if(root.left == null && root.right == null){
			ans.remove(ans.size()-1);
			return;
		}else {
			if(root.left!=null) {
				findPath(list, ans, root.left, sum);		
			}
			if(root.right!=null) {
				findPath(list, ans, root.right, sum);	
			}
		}
		if(ans.size()>=1) {
			ans.remove(ans.size()-1);
		}
		
		return;
	}
}
