package leetcode;

import java.util.Arrays;
import java.util.Scanner;

public class ThreeSumClosest {
	public int threeSum(int[] nums, int target) {
		if(nums.length<3 || nums == null) {
			return -1;
		}
		Arrays.sort(nums);
		int length = nums.length;
		int ans = nums[0] + nums[1] + nums[2];
		for(int i=0;i<length-2;i++) {
			int left = i+1;
			int right = length - 1;
			while(left<right) {
				int sum = nums[i] + nums[left] + nums[right];
				if(Math.abs(sum-target) < Math.abs(ans-target)) {
					ans = sum;
				}
				if(sum < target) {
					left += 1;
				}else {
					right -= 1;
				}
			}
		}
		return ans;
	}
	public static void main(String[] args) {
		int[] nums = new int[] {-1,2,1,-4};
		Scanner in = new Scanner(System.in);
		int target = Integer.parseInt(in.nextLine());
		ThreeSumClosest tsc = new ThreeSumClosest();
		System.out.println(tsc.threeSum(nums, target));
	}
}
