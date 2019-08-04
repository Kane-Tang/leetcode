package leetcode;

public class HouseRobber {
	public int rob(int[] nums) {
		int length = nums.length;
		int sum = 0;
//		return getMax(nums, 0, sum);
		int pre = 0;
		int cur = 0;
		for(int i=0;i<length;i++) {
			int tmp = cur;
			cur = Integer.max(pre+nums[i], cur);
			pre = tmp;
		}
		return cur;
	}
	
//	public int getMax(int[] nums, int index, int sum) {
//		if(index >= nums.length) {
//			return sum;
//		}
//		if(index == nums.length-1) {
//			return sum+nums[index];
//		}
//		return Integer.max(getMax(nums, index+2, sum+nums[index]), getMax(nums, index+3, sum+nums[index+1]));
//	}
	
	public static void main(String[] args) {
		HouseRobber hr = new HouseRobber();
		int[] nums = new int[] {2,1,1,2};
		System.out.println(hr.rob(nums));
	}
}
