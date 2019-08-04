package leetcode;

public class MaxProductArray {
	public int maxProduct(int[] nums) {
		int ans = Integer.MIN_VALUE;
		int length = nums.length;
		for(int start = 0;start < length;start++) {
			int tmp = nums[start];
			if(tmp>ans) {
				ans = tmp;
			}
			for(int end = start+1; end<length; end++) {
				tmp = tmp * nums[end];
				if(tmp>ans) {
					ans = tmp;
				}
			}
		}
		return ans;
	}
	
	public static void main(String[] args) {
		MaxProductArray mpa = new MaxProductArray();
		int[] nums = new int[] {-2,0,-1};
		System.out.println(mpa.maxProduct(nums));
	}
}
