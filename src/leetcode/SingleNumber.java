package leetcode;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class SingleNumber {
	public int singleNumber(int[] nums) {
//		int l = nums.length;
//		HashMap<Integer, Integer> hm = new HashMap();
//		for(int i=0;i<l;i++) {
//			int data = nums[i];
//			hm.put(data, hm.getOrDefault(data, 0)+1);
//		}
//		
//		Iterator<Map.Entry<Integer, Integer>> iterator = hm.entrySet().iterator();
//		while(iterator.hasNext()) {
//			Map.Entry<Integer, Integer> map = iterator.next();
//			if(map.getValue()==1) {
//				return map.getKey();
//			}
//		}
//		return 0;
		
		int l = nums.length;
		if(l==0) {
			return 0;
		}
		if(l==1) {
			return nums[0];
		}
		quickSort(nums, 0, l-1);
		for(int i=0;i<l;i++) {
			int data = nums[i];
			if(i==0) {
				if(data!=nums[i+1]) {
					return data;
				}
			}else if(i==l-1) {
				if(data!=nums[i-1]) {
					return data;
				}
			}else {
				if(data!=nums[i+1] && data!=nums[i-1]) {
					return data;
				}
			}
		}
		return 0;
	}
	
	public void quickSort(int[] nums, int low, int high) {
		if(low<high) {
			int par = partitions(nums, low, high);
			quickSort(nums, low, par-1);
			quickSort(nums, par+1, high);
		}
	}
	
	public int partitions(int[] nums, int low, int high) {
		int par = nums[high];
		int i = low-1;
		for(int j=low;j<high;j++) {
			if(nums[j]<=par) {
				i++;
				int tmp = nums[j];
				nums[j] = nums[i];
				nums[i] = tmp;
			}
		}
		int tmp = nums[i+1];
		nums[i+1] = nums[high];
		nums[high] = tmp;
		return i+1;
	}
}
