package leetcode;

public class NumArray {
	private int[] nums;
	public NumArray(int[] nums) {
		int l = nums.length;
		this.nums = new int[l];
		for(int i=0;i<l;i++) {
			if(i==0) {
				this.nums[i] = nums[i];
			}else {
				this.nums[i] = nums[i]+this.nums[i-1];
			}
			
		}
	}

	public int sumRange(int i, int j) {
		if(i==0)
			return nums[j];
		else
			return nums[j]-nums[i-1];
	}
}
