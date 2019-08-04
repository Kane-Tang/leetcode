package leetcode;

import java.util.Scanner;

public class RotatedArray {
	public int search(int[] nums, int target) {
		int l=nums.length;
		if(l==0) {
			return -1;
		}
		if(l==1) {
			if(nums[0]==target) {
				return 0;
			}
			else {
				return -1;
			}
		}
		int start=0;
		if(nums[0]<nums[l-1]) {
			start=0;
		}else {
			start=l/2;
			int left = 0;
			int right = l-1;
			while(left<=right) {
				start=(left+right)/2;
				if(nums[start]>nums[start+1]) {
					break;
				}
				else if(nums[start]<nums[left]){
					right = start - 1;
				}else {
					left = start+1;
				}
			}
//			while(start+1<=l-1&&nums[start]<nums[start+1]) {
//				start--;
//			}
			
			if(start+1<=l-1) {
				start++;
			}
			System.out.println(start);
		}
		if(nums[start]==target) {
			return start;
		}
		if(start==0) {
			return getTarget(nums,target,0,l-1);
		}
		if(nums[0]>target) {	//find target on the right side
			return getTarget(nums,target,start+1,l-1);
		}else {
			return getTarget(nums,target,0,start);
		}
	}
	
	public int getTarget(int[] nums,int target,int left,int right) {
		int index = left+right;
		index=index/2;
		if(left>right) {
			return -1;
		}
		if(index>=nums.length) {
			return -1;
		}
		if(nums[index]==target) {
			return index;
		}
		if(nums[index]>target) {
			return getTarget(nums,target,left,index-1);
		}else {
			return getTarget(nums,target,index+1,right);
		}
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		RotatedArray ra = new RotatedArray();
		int[] input = new int[] {5,1,3};
		System.out.println(ra.search(input, 5));
	}
}
