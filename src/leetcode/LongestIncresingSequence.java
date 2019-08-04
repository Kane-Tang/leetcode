package leetcode;

public class LongestIncresingSequence {
	public int lengthOfLIS(int[] nums) {
		int l = nums.length;
		if(l == 0) {
			return 0;
		}
		int[] dp = new int[l+1];
		dp[0] = 1;
		int max = 1;
		for(int i=1;i<l;i++) {
			int maxTmp = 0;
			for(int j=0;j<i;j++) {
				if(nums[j] < nums[i]) {
					maxTmp = Math.max(dp[j], maxTmp);
				}
			}
			dp[i] = maxTmp+1;
			max = Math.max(dp[i], max);
		}
		return max;
	}
}
