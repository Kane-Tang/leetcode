package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumTwo {
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		Arrays.sort(candidates);
		List<List<Integer>> res = new ArrayList();
		List<Integer> item = new ArrayList();
		findAnwser(res, candidates, target, item, 0);
		return res;
	}

	public void findAnwser(List<List<Integer>> res, int[] candidates, int target, List<Integer> item, int index) {
		if (target == 0) {
			//System.out.println(item);
			if(!res.contains(item)) {
				res.add(new ArrayList(item));
			}
			return;
		}
		if (target < 0 || index >= candidates.length) {// invalid item, do backtrack
			return;
		}
		for (int i = index; i < candidates.length; i++) {
			item.add(candidates[i]);
			findAnwser(res, candidates, target-candidates[i], item, i + 1);
			item.remove(item.size() - 1);
		}
	}

	public static void main(String[] args) {
		CombinationSumTwo cst = new CombinationSumTwo();
		//int[] candidates = new int[] { 10, 1, 2, 7, 6, 1, 5 };
		int[] candidates = new int[] { 1,2,3,4 };
		int target = 4;
		List<List<Integer>> list = cst.combinationSum2(candidates, target);
		System.out.println(list);
	}
}
