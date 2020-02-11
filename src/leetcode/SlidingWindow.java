package leetcode;

import java.util.ArrayList;
import java.util.List;

public class SlidingWindow {
	public int[] maxSlidingWindow(int[] nums, int k) {
//		int l = nums.length;
//		List<Integer> list = new ArrayList();
//		for(int i=0;i<l;i++) {
//			if(i==l-k+1) {
//				break;
//			}
//			int max = Integer.MIN_VALUE;
//			int start = i;
//			int end = i+k-1;
//			for(int j=start;j<=end;j++) {
//				if(nums[j]>max) {
//					max = nums[j];
//				}
//			}
//			list.add(max);
//		}
//		int[] array = new int[list.size()];
//		for(int i=0;i<list.size();i++) {
//			array[i] = list.get(i);
//		}
//		return array;
		
		//linear time
		int l = nums.length;
		if(l==0) {
			return new int[] {};
		}
		List<Integer> list = new ArrayList();
		//first, divide the total array into l/k blocks
		
		//left[i] = max element from block_start to index i
		int[] left = new int[l];
		//right[j] = max element from block_end to index j
		int[] right = new int[l];
		
		left[0] = nums[0];
		right[l-1] = nums[l-1];
		
		for(int i=1;i<l;i++) {
			if(i%k == 0) {//at the start point of a block
				left[i] = nums[i];
			}else {
				left[i] = Math.max(nums[i], left[i-1]);
			}
			
			int j = l-i-1;
			if((j+1)%k == 0) {
				right[j] = nums[j];
			}else {
				right[j] = Math.max(nums[j], right[j+1]);
			}
		}
		
		int[] array = new int[l-k+1];
		for(int i=0;i<l-k+1;i++) {
			array[i] = Math.max(right[i], left[i+k-1]);
		}
		return array;
	}
}
