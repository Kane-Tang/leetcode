package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
	public List<List<Integer>> threeSum(int[] nums) {
        List res = new ArrayList <List<Integer>>();
		Arrays.sort(nums);
		int length = nums.length;
		for(int i=0;i<length-2;i++) {
			if(i>0&&nums[i]==nums[i-1]) {
				continue;
			}
			int j = i+1;
			int k = length-1;
			int goal = -nums[i];
			while(j<k) {
				if(nums[j]+nums[k]==goal) {
					List tmp = new ArrayList();
					tmp.add(nums[i]);
					tmp.add(nums[j]);
					tmp.add(nums[k]);
					res.add(tmp);
					j += 1;
					k -= 1;
					while(j<k&&nums[j]==nums[j-1]) {
						j += 1;
					}
					while(j<k&&nums[k]==nums[k+1]) {
						k -= 1;
					}
				}else if(nums[j]+nums[k]>goal) {
					k -= 1;
				}else {
					j += 1;
				}
			}
		}
		return res;
    }
}
