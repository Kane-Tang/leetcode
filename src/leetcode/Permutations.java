package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Permutations {
	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> ans = new ArrayList();
		int l = nums.length;
		List<Integer> item = new ArrayList();
		for(int i = 0;i<l;i++) {
			item.add(nums[i]);
		}
		int first = 0;
		backtrack(item, first, ans,l);
		return ans;
	}
	
	public void backtrack(List<Integer> item, int first, List<List<Integer>> ans, int n) {
		if(first==n) {
			ans.add(new ArrayList(item));
		}
		for(int i=first;i<n;i++) {
			Collections.swap(item, first, i);
			backtrack(item,first+1,ans,n);
			Collections.swap(item, first, i);
		}
	}
	
	public static void main(String[] args) {
		Permutations p = new Permutations();
		int[] nums = new int[] {1,2,3};
		List<List<Integer>> ans = new ArrayList();
		ans = p.permute(nums);
		System.out.println(ans);
	}
}
