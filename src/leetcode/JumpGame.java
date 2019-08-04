package leetcode;

public class JumpGame {
	public boolean canJump(int[] nums) {
		int length = nums.length;
		int[] check = new int[length];
		int pos = length-1;
		for(int i = length-1; i>=0; i--) {
			if(i+nums[i]>=pos) {
				pos = i;
			}
		}
		if(pos == 0) {
			return true;
		}
		else {
			return false;
		}
	}
	
//	public boolean Jump(int[] nums, int[] check, int pos) {
//		if(pos == nums.length-1) {
//			return true;
//		}
//		if(check[pos]!=0) {
//			if(check[pos]==1) {
//				return false;
//			}
//			if(check[pos]==2) {e
//				return true;
//			}
//		}
//		if(nums[pos]==0) {
//			return false;
//		}
//		for(int i=1;i<=nums[pos];i++) {
//			if(pos+i<nums.length) {
//				if(Jump(nums, check, pos+i)==true) {
//					check[pos+i] = 2;
//					return true;
//				}
//			}
//			
//		}
//		return false;
//	}
	
	public static void main(String[] args) {
		int[] nums = new int[] {2,3,1,1,4};
		JumpGame jg = new JumpGame();
		System.out.println(jg.canJump(nums));
	}
}
