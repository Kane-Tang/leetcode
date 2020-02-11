package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntersectionOfArrayTwo {

	public IntersectionOfArrayTwo() {
		// TODO Auto-generated constructor stub
	}

	public int[] intersect(int[] nums1, int[] nums2) {
		int l1 = nums1.length;
		int l2 = nums2.length;
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		int i = 0;
		int j = 0;
		List<Integer> list = new ArrayList();
		while(i!=l1 && j!=l2) {
			if(nums1[i]==nums2[j]) {
				list.add(nums1[i]);
				i++;
				j++;
			}else if(nums1[i]>nums2[j]) {
				j++;
			}else {
				i++;
			}
		}
		int[] ans = new int[list.size()];
		for(int q=0;q<list.size();q++) {
			ans[q] = list.get(q);
		}
		return ans;
	}
}
