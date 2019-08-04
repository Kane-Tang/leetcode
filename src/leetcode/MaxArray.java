package leetcode;

import java.util.Arrays;

public class MaxArray {
	public int maxSubArray(int[] nums) {
		int l = nums.length;
		int ans = 0;
		int com = 0;
		for(int i=0;i<l;i++) {
			com = com+nums[i];
			if(ans<com) {
				ans = com;
			}
			if(com<0) {
				com=0;
			}
		}
		Arrays.sort(nums);
		if(nums[l-1]<0) {
			ans = nums[l-1];
		}
		return ans;
	}
	
	public static void main(String[] args) {
		MaxArray ma = new MaxArray();
		int[] nums = new int[] {-2,-1};
		System.out.println(ma.maxSubArray(nums));
	}
}
