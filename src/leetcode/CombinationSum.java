package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		Arrays.sort(candidates);
		int l = candidates.length;
		List<List<Integer>> res = new ArrayList();
		List<Integer> item = new ArrayList();
		findAnwser(res,candidates,target,item,0);
		//System.out.println(res);
		return res;
	}
	
	public void findAnwser(List<List<Integer>> res, int[] candidates, int target, List<Integer> item, int index) {
		int tmp = candidates[index];
		if(target == 0) {//find one solution
			//System.out.println(item);
			res.add(new ArrayList(item));
			return;
		}
		if(target<0||index>=candidates.length) {
			return;
		}else {
			for(int i=index;i<candidates.length;i++) {
				item.add(candidates[i]);
				findAnwser(res,candidates,target-candidates[i],item,i);
				item.remove(item.size()-1);//backtrack
			}
		}
		
	}
	
	public static void main(String[] args) {
		int[] candidates = new int[] {2,3};
		int target = 4;
		CombinationSum cs = new CombinationSum();
		List<List<Integer>> list = cs.combinationSum(candidates, target);
		System.out.println(list);
	}
}
