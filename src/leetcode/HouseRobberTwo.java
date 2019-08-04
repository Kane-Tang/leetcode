package leetcode;

public class HouseRobberTwo {
	public int rob(int[] nums) {
		int length = nums.length;
		if(length==1) {
			return nums[0];
		}
		return Math.max(findMax(nums,0,length-2),findMax(nums,1,length-1));
	}
	
	public int findMax(int[] nums, int low, int high) {
		int pre = 0;
		int cur = 0;
		for(int i=low;i<=high;i++) {
			int tmp = cur;
			cur = pre+nums[i];
			pre = Math.max(tmp, pre);
		}
		return Math.max(pre, cur);
	}
	
	public static void main(String[] args) {
		int[] nums = new int[] {2,3,2};
		HouseRobberTwo hrt = new HouseRobberTwo();
		System.out.println(hrt.rob(nums));
	}
}
