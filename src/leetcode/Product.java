package leetcode;

public class Product {
	public int[] productExceptSelf(int[] nums) {
		int l = nums.length;
		int[] ans = new int[l];
		int res = 1;
		int countZero = 0;
		for(int i=0;i<l;i++) {
			if(nums[i]==0) {
				countZero++;
				continue;
			}
			res = res*nums[i];
		}
		for(int i=0;i<l;i++) {
			if(countZero==0) {//no zero
				ans[i] = res/nums[i];
			}else if(countZero==1){//zero
				if(nums[i]==0) {
					ans[i] = res;
				}else {
					ans[i] = 0;
				}
			}else {
				ans[i] = 0;
			}
		}
		return ans;
	}
}
