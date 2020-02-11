package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class PermutationTwo {

	public PermutationTwo() {
		// TODO Auto-generated constructor stub
	}
	public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> resultSet = new ArrayList<>();
        List<Integer> permutation = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        
        Arrays.sort(nums); // sort the array first
        dfs(nums, visited, permutation, resultSet);
        return resultSet;
    }
    
    public void dfs(int[] nums, boolean[] visited, List<Integer> permutation, List<List<Integer>> resultSet) {
        // find one permutation, add into the resultSet, exit of recursion
        if (permutation.size() == nums.length) {//find one answer
            resultSet.add(new ArrayList<>(permutation));
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            // number is the same as the previous one, avoid reusing it
            if (i > 0 && visited[i - 1] == false && nums[i] == nums[i - 1]) {
                continue;
            }
            
            permutation.add(nums[i]);
            visited[i] = true;
            dfs(nums, visited, permutation, resultSet);//try one route, if find it, it returns, else, cancel this choice and continue
            // Backtracking, modify the visited status
            permutation.remove(permutation.size() - 1);
            visited[i] = false;
        }
    }
//	public List<List<Integer>> permuteUnique(int[] nums) {
//        List<List<Integer>> res = new ArrayList<List<Integer>>();
//        Arrays.sort(nums);
//        LinkedList<Integer> list = new LinkedList<Integer>();
//        for (int num : nums) list.add(num);
//        permute(list, 0, res);
//        return res;
//    }
//    private void permute(LinkedList<Integer> nums, int start, List<List<Integer>> res){
//        if (start == nums.size() - 1){
//            res.add(new LinkedList<Integer>(nums));
//            return;
//        }
//        for (int i = start; i < nums.size(); i++){
//            if (i > start && nums.get(i) == nums.get(i - 1)) {
//            	continue;
//            }
//            nums.add(start, nums.get(i));
//            nums.remove(i + 1);
//            permute(nums, start + 1, res);
//            nums.add(i + 1, nums.get(start));
//            nums.remove(start);
//        }
//    }
}
