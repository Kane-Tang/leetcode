package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class IntersectionOfArray {
	public int[] intersection(int[] nums1, int[] nums2) {
		int l1 = nums1.length;
		int l2 = nums2.length;
		List<Integer> list = new ArrayList();
		HashSet<Integer> set1 = new HashSet();
		HashSet<Integer> set2 = new HashSet();
		for(int i=0;i<l1;i++) {
			set1.add(nums1[i]);
		}
		for(int i=0;i<l2;i++) {
			set2.add(nums2[i]);
		}
		if(set1.size()<set2.size()) {
			int[] output = new int[set1.size()];
			int index = 0;
			for(Integer s: set1) {
				if(set2.contains(s)) {
					output[index++]=s;
				}
			}
			return Arrays.copyOf(output, index);
		}else {
			int[] output = new int[set2.size()];
			int index = 0;
			for(Integer s: set2) {
				if(set1.contains(s)) {
					output[index++]=s;
				}
			}
			return Arrays.copyOf(output, index);
		}
	}
}
