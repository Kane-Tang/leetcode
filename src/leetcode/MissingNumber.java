package leetcode;

import java.util.Arrays;

public class MissingNumber {

	public MissingNumber() {
		// TODO Auto-generated constructor stub
	}

	public int missingNumber(int[] nums) {
		int l = nums.length;
		Arrays.sort(nums);
		int ans = 0;
		for(int i=0;i<=l;i++) {
			if(i>l-1|| nums[i]!=i) {
				return i;
			}
		}
		return 0;
	}
}
