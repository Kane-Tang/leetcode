package leetcode;

import java.util.Arrays;

public class PartitionForTwoEqualArray {

	public PartitionForTwoEqualArray() {
		// TODO Auto-generated constructor stub
	}

	public boolean canPartition(int[] nums) {
		//0-1 knapsack
		int l = nums.length;
		int sum = 0;
		for(int n: nums) {
			sum += n;
		}
		if(sum%2 != 0) {
			return false;
		}
		
		sum = sum/2;
		boolean[][] dp = new boolean[l+1][sum+1];
		for(int i=0;i<=l;i++) {
			for(int j=0;j<=sum;j++) {
				dp[i][j] = false;
			}
		}
		dp[0][0] = true;
		for(int i=0;i<=l;i++) {
			dp[i][0] = true;
		}
		for(int j=0;j<=sum;j++) {
			dp[0][j] = false;
		}
		
		for(int i=1;i<=l;i++) {
			for(int j=1;j<=sum;j++) {
				dp[i][j] = dp[i-1][j];//we don't pick nums[i]
				if(j >= nums[i-1]) {//choose nums[i], but need to make sure the current one is smaller than the goal sum
					dp[i][j] = (dp[i][j] || dp[i-1][j-nums[i-1]]);
				}
			}
		}
		
		return dp[l][sum];
	}
}
