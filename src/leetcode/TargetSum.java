package leetcode;

import java.util.HashMap;
import java.util.Map;

public class TargetSum {

	public TargetSum() {
		// TODO Auto-generated constructor stub
	}

	private int res = 0;
	public int findTargetSumWays(int[] nums, int S) {
		/*recursion
		traverse(nums, S, 0, 0);
		return res;
		*/
		if(nums.length==0) return 0;
        Map<Integer, Integer> prev = new HashMap<Integer, Integer>();;
        Map<Integer, Integer> cur;
        for(int i = 0; i< nums.length; i++){
            //for nums[0]
            if(i==0){
                prev.put(nums[0], 1);
                if(!prev.containsKey(-nums[0])){
                    prev.put(-nums[0], 1);
                }else{
                    prev.put(-nums[0], 2); // if nums[0] is 0.
                }
            }else{
                cur = new HashMap<Integer, Integer>();
                for(Map.Entry<Integer, Integer> entry: prev.entrySet()){
                    int sumSoFar = entry.getKey();
                    int count = entry.getValue();
                    // add num[i]
                     if(!cur.containsKey(sumSoFar+nums[i])){
                         cur.put(sumSoFar+nums[i], count);
                     }else{
                         cur.put(sumSoFar+nums[i], cur.get(sumSoFar+nums[i])+count);
                     }
                     // subtract num[i]
                     if(!cur.containsKey(sumSoFar-nums[i])){
                         cur.put(sumSoFar-nums[i], count);
                     }else{
                         cur.put(sumSoFar-nums[i], cur.get(sumSoFar-nums[i])+count);
                     }
                }
                prev = cur;
            }
        }
        return prev.containsKey(S)? prev.get(S) : 0;
		/*
		int l = nums.length;
		int[][] dp = new int[l + 1][2000];

		for (int j = 1; j < 2000; j++) {
			dp[0][j] = 0;
		}
        dp[0][1000] = 1;
		for (int i = 1; i <= l; i++) {
			for (int j = 0; j <= S; j++) {
				dp[i][j + nums[i - 1]+1000] += dp[i - 1][j+1000];
				dp[i][j - nums[i - 1]+1000] += dp[i - 1][j+1000];
			}
		}
		return dp[l][S+1000];
		*/
	}
	
	public void traverse(int[] nums, int target, int index, int sum) {
		if(index == nums.length) {
			if(sum == target) {
				res++;
				return;
			}
		}else {
			traverse(nums, target, index+1, sum+nums[index]);
			traverse(nums, target, index+1, sum-nums[index]);
		}
	}
}
