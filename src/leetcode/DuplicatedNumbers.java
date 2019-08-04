package leetcode;

import java.util.HashMap;

public class DuplicatedNumbers {
	public int findDuplicate(int[] nums) {
		int l = nums.length;
		int count = 0;
//		You must not modify the array (assume the array is read only).
//		You must use only constant, O(1) extra space.
//		Your runtime complexity should be less than O(n2).
//		HashMap<Integer,Integer> hm = new HashMap();
//		for(int i=0;i<l;i++) {
//			if(hm.containsKey(nums[i])) {
//				hm.put(nums[i], hm.get(nums[i])+1);
//				count = nums[i];
//				break;
//			}else {
//				hm.put(nums[i], 1);
//			}
//		}
//		return count;
		
//		for(int i=0;i<l;i++) {
//			for(int j=0;j<i;j++) {
//				if(nums[j]==nums[i]) {
//					return nums[i];
//				}
//			}
//		}
//		return 0;
		
		//Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive),
		//which means we can find the every value of the item in the array from the index
		
		//Floyd's Tortoise and Hare (Cycle Detection) 
		int tortoise = nums[0];
		int hare = nums[0];
		do {
			tortoise = nums[tortoise];
			hare = nums[nums[hare]];
		}while(tortoise!=hare);
		//to make sure hare is one more step faster than tortoise
		
		int ptr1 = nums[0];
		int ptr2 = tortoise;
		while(ptr1 != ptr2) {
			ptr1 = nums[ptr1];
			ptr2 = nums[ptr2];
		}
		
		return ptr1;
	}
}
